package com.eObrazovanje.studentServices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eObrazovanje.studentServices.entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer>{
	
}
