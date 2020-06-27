package com.eObrazovanje.studentServices.service;

import com.eObrazovanje.studentServices.entity.Authority;
import com.eObrazovanje.studentServices.repository.AuthorityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityService implements AuthorityServiceInterface {

    private final AuthorityRepository authorityRepository;

    public AuthorityService(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    @Override
    public Authority findById(Integer authorityId) {
        return authorityRepository.findById(authorityId).orElse(null);
    }

    @Override
    public List<Authority> findAll() {
        return authorityRepository.findAll();
    }

    @Override
    public Authority save(Authority authority) {
        return authorityRepository.save(authority);
    }

    @Override
    public void deleteById(int userId) {
        authorityRepository.deleteById(userId);
    }
}
