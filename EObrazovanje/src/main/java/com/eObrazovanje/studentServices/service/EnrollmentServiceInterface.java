package com.eObrazovanje.studentServices.service;

import java.util.List;
import com.eObrazovanje.studentServices.DTO.EnrollmentDTO;

public interface EnrollmentServiceInterface {
	
	EnrollmentDTO findOne(int id);
	List<EnrollmentDTO> findAll();
	int save(EnrollmentDTO enrollment);
	List<EnrollmentDTO> getEnrolledStudents(int id);
	void update(EnrollmentDTO enrollmentDTO);
	boolean remove(int id);
}
