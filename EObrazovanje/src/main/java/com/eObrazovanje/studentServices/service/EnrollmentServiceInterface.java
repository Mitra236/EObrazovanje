package com.eObrazovanje.studentServices.service;

import java.util.List;
import com.eObrazovanje.studentServices.DTO.EnrollmentDTO;
import com.eObrazovanje.studentServices.DTO.EnrollmentToAddDTO;

public interface EnrollmentServiceInterface {
	
	EnrollmentDTO findOne(int id);
	List<EnrollmentDTO> findAll();
	int save(EnrollmentToAddDTO enrollment);
	List<EnrollmentDTO> getEnrolledStudents(int id);
	Boolean removeEnrollment(int courseId, int studentId);
	void update(EnrollmentDTO enrollmentDTO);
	
	
	boolean remove(int id);
}
