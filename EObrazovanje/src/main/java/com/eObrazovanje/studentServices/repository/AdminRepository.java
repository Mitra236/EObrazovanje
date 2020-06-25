package com.eObrazovanje.studentServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eObrazovanje.studentServices.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
