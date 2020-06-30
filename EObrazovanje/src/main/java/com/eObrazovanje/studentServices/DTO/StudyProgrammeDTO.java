package com.eObrazovanje.studentServices.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.eObrazovanje.studentServices.entity.Course;
import com.eObrazovanje.studentServices.entity.Student;
import com.eObrazovanje.studentServices.entity.StudyProgramme;

public class StudyProgrammeDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public int id;
	public String name;
	public List<StudentDTO> studentsDTO;
	public List<CourseDTO> coursesDTO;
	
	public StudyProgrammeDTO(StudyProgramme prog) {
		this.id = prog.getId();
		this.name = prog.getName();
		this.coursesDTO= new ArrayList<CourseDTO>();
		this.studentsDTO = new ArrayList<StudentDTO>();
		List<Student> students = prog.getStudents();
		for(Student s: students) {
			studentsDTO.add(new StudentDTO(s));
		}
		List<Course> courses = prog.getCourses();
		for(Course c:courses) {
			coursesDTO.add(new CourseDTO(c));
		}
	}
	
	
	public StudyProgrammeDTO() {
		super();
	}
	
	public StudyProgrammeDTO(int id, String name, List<Student> students, List<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		if(students != null) {
			this.studentsDTO = new ArrayList<StudentDTO>();
			for(Student s : students) {
				this.studentsDTO.add(new StudentDTO(s));
			}
		}
		if(courses != null) {
			this.coursesDTO = new ArrayList<CourseDTO>();
			for(Course c : courses) {
				this.coursesDTO.add(new CourseDTO(c));
			}
		}
	}

	
}
