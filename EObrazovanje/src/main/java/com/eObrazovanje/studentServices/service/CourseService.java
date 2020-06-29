package com.eObrazovanje.studentServices.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eObrazovanje.studentServices.DTO.CourseDTO;
import com.eObrazovanje.studentServices.DTO.EnrollmentDTO;
import com.eObrazovanje.studentServices.entity.Course;
import com.eObrazovanje.studentServices.entity.Enrollment;
import com.eObrazovanje.studentServices.entity.Student;
import com.eObrazovanje.studentServices.repository.CourseRepository;
import com.eObrazovanje.studentServices.repository.EnrollmentRepository;
import com.eObrazovanje.studentServices.repository.StudentRepository;

@Service
public class CourseService implements CourseServiceInterface{
	
	@Autowired
	CourseRepository courseRepo;
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	EnrollmentRepository enrollmentRepo;

	@Override
	public Course findOne(int id) {
		return courseRepo.findById(id).orElse(null);
	}

	@Override
	public List<CourseDTO> findAll() {
		List<CourseDTO> courseDTOs = new ArrayList<CourseDTO>();
		for (Course c: courseRepo.findAll()) {
			courseDTOs.add(new CourseDTO(c));
		}
		return courseDTOs;
	}

	@Override
	public int save(Course course) {
		return courseRepo.save(course).getId();
	}

	@Override
	public boolean remove(int id) {
		Course course = courseRepo.findById(id).orElse(null);
		if (course == null) return false;
		
		courseRepo.deleteById(id);
		return true;
	}

	@Override
	public void update(Course course) {
		Course updatedCourse = courseRepo.findById(course.getId()).orElse(null);
		updatedCourse.setCourseCode(course.getCourseCode());
		updatedCourse.setName(course.getName());
		updatedCourse.setECTS(course.getECTS());
		updatedCourse.setLectures(course.getLectures());
		updatedCourse.setPracticalCLasses(course.getPracticalCLasses());
		updatedCourse.setStudyProgramme(course.getStudyProgramme());
		courseRepo.save(updatedCourse);
	}

	@Override
	public int saveCourseStudents(CourseDTO courseDTO) {
		Course course = courseRepo.findById(courseDTO.id).orElse(null);
		List<EnrollmentDTO> enrollmentsDTO = courseDTO.enrollmentDTOs;
		Enrollment enrollment = new Enrollment();
		
		for (EnrollmentDTO e: enrollmentsDTO) {
			Student student = studentRepo.findById(e.student.id).orElse(null);
			enrollment.setCourse(course);
			enrollment.setStartDate(e.startDate);
			enrollment.setEndDate(e.endDate);
			enrollment.setStudent(student);
			enrollmentRepo.save(enrollment);
			course.getEnrollment().add(enrollment);
		}

		return enrollment.getId();
	}

}
