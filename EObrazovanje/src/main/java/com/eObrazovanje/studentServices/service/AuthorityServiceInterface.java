package com.eObrazovanje.studentServices.service;

import com.eObrazovanje.studentServices.entity.Authority;

import java.util.List;

@SuppressWarnings("unused")
public interface AuthorityServiceInterface {

    Authority findById(Integer authorityId);

    List<Authority> findAll();

    Authority save(Authority authority);

    void deleteById(int authorityId);

}
