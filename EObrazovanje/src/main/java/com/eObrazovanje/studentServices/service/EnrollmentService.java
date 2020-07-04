package com.eObrazovanje.studentServices.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eObrazovanje.studentServices.DTO.EnrollmentDTO;
import com.eObrazovanje.studentServices.DTO.EnrollmentToAddDTO;
import com.eObrazovanje.studentServices.DTO.StudentDTO;
import com.eObrazovanje.studentServices.entity.Course;
import com.eObrazovanje.studentServices.entity.Enrollment;
import com.eObrazovanje.studentServices.repository.CourseRepository;
import com.eObrazovanje.studentServices.repository.EnrollmentRepository;
import com.eObrazovanje.studentServices.repository.StudentRepository;

@Service
public class EnrollmentService implements EnrollmentServiceInterface {
	
	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	@Autowired
	CourseRepository courseRepo;
	
	@Autowired
	StudentRepository studentRepo;

	@Override
	public EnrollmentDTO findOne(int id) {
		return new EnrollmentDTO(enrollmentRepository.findById(id).orElse(null));
	}

	@Override
	public List<EnrollmentDTO> findAll() {
		List<EnrollmentDTO> enrollmentDTOs = new ArrayList<>();
		for (Enrollment e: enrollmentRepository.findAll()) {
			enrollmentDTOs.add(new EnrollmentDTO(e));
		}
		return enrollmentDTOs;
	}

	@Override
	public int save(EnrollmentToAddDTO enrollmentDTO) {
		Enrollment enrollment = new Enrollment();
		enrollment.setCourse(courseRepo.findById(enrollmentDTO.course).orElse(null));
		enrollment.setStudent(studentRepo.findById(enrollmentDTO.student).orElse(null));
		enrollment.setStartDate(enrollmentDTO.startDate);
		enrollment.setEndDate(enrollmentDTO.endDate);
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

	@Override
	public void update(EnrollmentDTO enrollmentDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean remove(int id) {
		Enrollment enrollment = enrollmentRepository.findById(id).orElse(null);
		if(enrollment == null) {
			return false;
		}
		enrollmentRepository.deleteById(id);;
		return true;
	}

}
