package com.eObrazovanje.studentServices.service;

import com.eObrazovanje.studentServices.entity.AuthUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface AuthUserServiceInterface extends UserDetailsService {
    AuthUser findByUsername(String username);

    AuthUser findOne(Integer id);

    List<AuthUser> findAll();

    AuthUser save(AuthUser user);

    void remove(Integer id);
}
