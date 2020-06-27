package com.eObrazovanje.studentServices.config;

import com.eObrazovanje.studentServices.security.TokenHelper;
import com.eObrazovanje.studentServices.security.auth.RestAuthenticationEntryPoint;
import com.eObrazovanje.studentServices.security.auth.TokenAuthenticationFilter;
import com.eObrazovanje.studentServices.service.AuthUserServiceInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private final AuthUserServiceInterface authUserServiceInterface;
    private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    private final TokenHelper tokenHelper;

    public WebSecurityConfig(AuthUserServiceInterface authUserServiceInterface,
                             RestAuthenticationEntryPoint restAuthenticationEntryPoint,
                             TokenHelper tokenHelper) {
        this.authUserServiceInterface = authUserServiceInterface;
        this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
        this.tokenHelper = tokenHelper;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        try {
            auth.userDetailsService(authUserServiceInterface).passwordEncoder(passwordEncoder);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()
                .authorizeRequests()
                .antMatchers("/api/auth/**").permitAll()
                .anyRequest().authenticated().and()
                .addFilterBefore(new TokenAuthenticationFilter(tokenHelper, authUserServiceInterface), BasicAuthenticationFilter.class);

        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(
                HttpMethod.POST,
                "/api/auth"
        );
        web.ignoring().antMatchers(
                HttpMethod.GET,
                "/"
        );
    }
}
