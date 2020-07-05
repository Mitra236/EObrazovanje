package com.eObrazovanje.studentServices.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eObrazovanje.studentServices.DTO.CourseDTO;
import com.eObrazovanje.studentServices.DTO.EnrollmentDTO;
import com.eObrazovanje.studentServices.DTO.ExamRegistrationDTO;
import com.eObrazovanje.studentServices.DTO.StudentDTO;
import com.eObrazovanje.studentServices.DTO.StudentDetailsDTO;
import com.eObrazovanje.studentServices.DTO.StudyProgrammeDTO;
import com.eObrazovanje.studentServices.entity.Course;
import com.eObrazovanje.studentServices.entity.EExamStatus;
import com.eObrazovanje.studentServices.entity.Enrollment;
import com.eObrazovanje.studentServices.entity.Exam;
import com.eObrazovanje.studentServices.entity.ExamRegistration;
import com.eObrazovanje.studentServices.entity.Student;
import com.eObrazovanje.studentServices.entity.StudyProgramme;
import com.eObrazovanje.studentServices.repository.CourseRepository;
import com.eObrazovanje.studentServices.repository.EnrollmentRepository;
import com.eObrazovanje.studentServices.repository.ExamRepository;
import com.eObrazovanje.studentServices.repository.StudentRepository;
import com.eObrazovanje.studentServices.repository.StudyProgrammeRepository;

@Service
public class StudyProgrammeService implements StudyProgrammeServiceInterface{
	
	@Autowired
	StudyProgrammeRepository studyProgrammeRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	ExamRepository examRepository;
	
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	@Override
	public StudyProgrammeDTO findOne(int id) {
		StudyProgramme programme = studyProgrammeRepository.findById(id).orElse(null);
		return new StudyProgrammeDTO(programme);
	}

	@Override
	public List<StudyProgrammeDTO> findAll() {
		List<StudyProgramme> progs = studyProgrammeRepository.findAll();
		List<StudyProgrammeDTO> progsDTO = new ArrayList<>();
		for(StudyProgramme p : progs) {
			progsDTO.add(new StudyProgrammeDTO(p));
		}
		return progsDTO;
	}

	@Override
	public int save(StudyProgramme studyProgramme) {
		// TODO Auto-generated method stub
		return studyProgrammeRepository.save(studyProgramme).getId();
	}

	@Override
	public List<CourseDTO> findCoursesByProgramme(int id) {
		StudyProgramme prog = studyProgrammeRepository.findById(id).orElse(null);
		List<CourseDTO> coursesByProgramme = new ArrayList<CourseDTO>();
		for (Course course : prog.getCourses()) {
			coursesByProgramme.add(new CourseDTO(course));
		}
		return coursesByProgramme;
	}

	@Override
	public int saveCourseToProgramme(StudyProgrammeDTO prog, CourseDTO coDTO) {
		StudyProgramme program = studyProgrammeRepository.findById(prog.id).orElse(null);
		Course co = courseRepository.getOne(coDTO.id);
		if(co == null) return 0;

		co.setStudyProgramme(program);
		
		program.getCourses().add(co);
		return co.getId();
	}
	

	@Override
	public boolean remove(int id) {
		studyProgrammeRepository.deleteById(id);
		return true;
	}

	@Override
	public boolean removeCourseFromProgramme(int id, int programmeId) {
		StudyProgramme prog = studyProgrammeRepository.getOne(programmeId);
		if(prog == null)
			return false;
		
		Course course = courseRepository.getOne(id);
		if(course == null)
			return false;
		
		List<Course> coursesToRemove = new ArrayList<Course>();
		for(Course c : prog.getCourses()) {
			if(c.getId() == id)
				coursesToRemove.add(c);
		}
		for(Course c : coursesToRemove) {
			prog.getCourses().remove(c);
			c.setStudyProgramme(null);
		}
		
		return true;
	}

	@Override
	public int saveStudentToProgramme(StudyProgrammeDTO studyProgramme, StudentDTO s) {
		StudyProgramme program = studyProgrammeRepository.findById(studyProgramme.id).orElse(null);
		Student student = studentRepository.getOne(s.id);
		if(student == null)
			return 0;
		
		student.setStudyProgramme(program);
		program.getStudents().add(student);
		
		studentRepository.save(student);
		studyProgrammeRepository.save(program);
		
		return student.getId();
	}

	@Override
	public boolean removeStudentFromProgramme(int id, int programmeId) {
		StudyProgramme prog = studyProgrammeRepository.getOne(programmeId);
		if(prog == null)
			return false;
		
		Student s = studentRepository.getOne(id);
		if(s == null)
			return false;
		
		for(Student student: prog.getStudents()) {
			if(student.getId() == id) {
				prog.getStudents().remove(student);
				student.setStudyProgramme(null);
				

				for(Enrollment e: student.getEnrollment()) {
					enrollmentRepository.delete(e);
				}
				
				studentRepository.save(student);
			}
		}
		
		studyProgrammeRepository.save(prog);
		return true;
	}

	@Override
	public List<StudentDTO> findStudentsByProgramme(int id) {
		StudyProgramme prog = studyProgrammeRepository.findById(id).orElse(null);
		List<StudentDTO> studentsByProgramme = new ArrayList<StudentDTO>();
		for(Student s : prog.getStudents()) {
			studentsByProgramme.add(new StudentDTO(s));
		}
		return studentsByProgramme;
	}
}
