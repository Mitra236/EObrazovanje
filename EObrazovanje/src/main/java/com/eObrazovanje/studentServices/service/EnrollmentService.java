package com.eObrazovanje.studentServices.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eObrazovanje.studentServices.DTO.EnrollmentDTO;
import com.eObrazovanje.studentServices.DTO.StudentDTO;
import com.eObrazovanje.studentServices.entity.Course;
import com.eObrazovanje.studentServices.entity.Enrollment;
import com.eObrazovanje.studentServices.repository.CourseRepository;
import com.eObrazovanje.studentServices.repository.EnrollmentRepository;

@Service
public class EnrollmentService implements EnrollmentServiceInterface {
	
	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	@Autowired
	CourseRepository courseRepo;

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

	@Override
	public List<EnrollmentDTO> getEnrolledStudents(int id) {
		Course course = courseRepo.findById(id).orElse(null);
		List<Enrollment> enrollments = course.getEnrollment();
		List<EnrollmentDTO> enrollmentsDTO = new ArrayList<EnrollmentDTO>();
		for(Enrollment e: enrollments) {
			EnrollmentDTO enrollmentDTO = new EnrollmentDTO();
			enrollmentDTO.id = e.getId();
			enrollmentDTO.startDate = e.getStartDate();
			enrollmentDTO.endDate = e.getEndDate();
			enrollmentDTO.student = new StudentDTO(e.getStudent());
			enrollmentsDTO.add(enrollmentDTO);
		}
		
		return enrollmentsDTO;
	}

}
