package com.eObrazovanje.studentServices.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eObrazovanje.studentServices.DTO.StudentBasicInfoDTO;
import com.eObrazovanje.studentServices.entity.Enrollment;
import com.eObrazovanje.studentServices.entity.Student;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer>{
	
}
