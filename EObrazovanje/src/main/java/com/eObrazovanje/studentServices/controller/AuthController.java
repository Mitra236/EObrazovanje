package com.eObrazovanje.studentServices.controller;

import com.eObrazovanje.studentServices.entity.AuthUser;
import com.eObrazovanje.studentServices.entity.Authority;
import com.eObrazovanje.studentServices.entity.UserTokenState;
import com.eObrazovanje.studentServices.security.TokenHelper;
import com.eObrazovanje.studentServices.security.auth.JwtAuthenticationRequest;
import com.eObrazovanje.studentServices.service.AuthUserServiceInterface;
import com.eObrazovanje.studentServices.service.AuthorityServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final TokenHelper tokenHelper;
    private final AuthUserServiceInterface authUserServiceInterface;
    private final AuthorityServiceInterface authorityService;

    public AuthController(AuthenticationManager authenticationManager, TokenHelper tokenHelper, AuthUserServiceInterface authUserServiceInterface, AuthorityServiceInterface authorityService) {
        this.authenticationManager = authenticationManager;
        this.tokenHelper = tokenHelper;
        this.authUserServiceInterface = authUserServiceInterface;
        this.authorityService = authorityService;
    }

    @RequestMapping(value = "/auth/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        AuthUser authUser = (AuthUser) authentication.getPrincipal();
        String jws = tokenHelper.generateToken(authUser.getUsername());
        int expiresIn = tokenHelper.getExpiredIn();


        return ResponseEntity.ok(new UserTokenState(jws, expiresIn, authUser.getIntRole()));
    }

    @RequestMapping(value = "/auth/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> addUser(@RequestBody AuthUser authUser) {

        String encodedPassword = new BCryptPasswordEncoder().encode(authUser.getPassword());
        authUser.setPassword(encodedPassword);

        System.out.println(encodedPassword);

        List<Authority> authorities = new ArrayList<>();
        authorities.add(authorityService.findById(2));
        authUser.setAuthorities(authorities);

        authUserServiceInterface.save(authUser);

        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
