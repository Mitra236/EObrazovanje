package com.eObrazovanje.studentServices.security.auth;

import com.eObrazovanje.studentServices.entity.AuthUser;
import com.eObrazovanje.studentServices.security.TokenHelper;
import com.eObrazovanje.studentServices.service.AuthUserServiceInterface;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("unused")
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private final Log logger = LogFactory.getLog(this.getClass());

    private final TokenHelper tokenHelper;

    private final AuthUserServiceInterface authUserServiceInterface;

    public TokenAuthenticationFilter(TokenHelper tokenHelper, AuthUserServiceInterface authUserServiceInterface) {
        this.tokenHelper = tokenHelper;
        this.authUserServiceInterface = authUserServiceInterface;
    }


    @Override
    public void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {

        String username;
        String authToken = tokenHelper.getToken(request);

        if (authToken != null) {
            username = tokenHelper.getUsernameFromToken(authToken);
            if (username != null) {
                AuthUser authUser = authUserServiceInterface.findByUsername(username);
                if (tokenHelper.validateToken(authToken, authUser)) {
                    TokenBasedAuthentication authentication = new TokenBasedAuthentication(authUser);
                    authentication.setToken(authToken);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        chain.doFilter(request, response);
    }

}