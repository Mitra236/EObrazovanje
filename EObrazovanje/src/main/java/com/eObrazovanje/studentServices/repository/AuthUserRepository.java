package com.eObrazovanje.studentServices.repository;

import com.eObrazovanje.studentServices.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Integer> {
    AuthUser getByUsername(String username);
}
