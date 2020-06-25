package com.eObrazovanje.studentServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eObrazovanje.studentServices.entity.ExamRegistration;

public interface ExamRegistrationRepository extends JpaRepository<ExamRegistration, Integer> {

}
