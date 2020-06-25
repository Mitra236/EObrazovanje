package com.eObrazovanje.studentServices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eObrazovanje.studentServices.entity.Enrollment;
import com.eObrazovanje.studentServices.repository.EnrollmentRepository;

@Service
public class EnrollmentService implements EnrollmentServiceInterface {
	
	@Autowired
	EnrollmentRepository enrollmentRepository;

	@Override
	public Enrollment findOne(int id) {
		// TODO Auto-generated method stub
		return enrollmentRepository.findById(id).orElse(null);
	}

	@Override
	public List<Enrollment> findAll() {
		// TODO Auto-generated method stub
		return enrollmentRepository.findAll();
	}

	@Override
	public int save(Enrollment enrollment) {
		// TODO Auto-generated method stub
		return enrollmentRepository.save(enrollment).getId();
	}

}
