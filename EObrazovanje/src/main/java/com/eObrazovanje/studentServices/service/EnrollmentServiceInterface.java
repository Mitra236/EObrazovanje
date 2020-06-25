package com.eObrazovanje.studentServices.service;

import java.util.List;

import com.eObrazovanje.studentServices.entity.Enrollment;

public interface EnrollmentServiceInterface {
	
	Enrollment findOne(int id);
	List<Enrollment> findAll();
	int save(Enrollment enrollment);

}
