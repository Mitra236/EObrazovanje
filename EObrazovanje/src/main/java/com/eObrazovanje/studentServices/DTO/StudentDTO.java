package com.eObrazovanje.studentServices.DTO;

import com.eObrazovanje.studentServices.entity.Student;

public class StudentDTO {

	public int id;
	public String index;
	public String username;
	public String password;
	public String firstName;
	public String lastName;
	public String email;
	public StudyProgrammeDTO studyProgramme;
	
	public StudentDTO(Student student) {
		this.id = student.getId();
		this.index = student.getIndex();
		this.username = student.getUsername();
		this.password = student.getPassword();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();
		this.studyProgramme = new StudyProgrammeDTO(student.getStudyProgramme());
	}

	public StudentDTO() {
		super();
	}
	
}
