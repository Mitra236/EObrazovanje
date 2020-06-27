package com.eObrazovanje.studentServices.service;

import com.eObrazovanje.studentServices.entity.AuthUser;
import com.eObrazovanje.studentServices.repository.AuthUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthUserService implements AuthUserServiceInterface {
    private final AuthUserRepository authUserRepository;

    public AuthUserService(AuthUserRepository authUserRepository) {
        this.authUserRepository = authUserRepository;
    }

    @Override
    public AuthUser findByUsername(String username) {
        return authUserRepository.getByUsername(username);
    }

    @Override
    public AuthUser findOne(Integer id) {
        return authUserRepository.findById(id).orElse(null);
    }

    @Override
    public List<AuthUser> findAll() {
        return authUserRepository.findAll();
    }

    @Override
    public AuthUser save(AuthUser user) {
        return authUserRepository.save(user);
    }

    @Override
    public void remove(Integer id) {
        authUserRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return authUserRepository.getByUsername(username);
    }
}
