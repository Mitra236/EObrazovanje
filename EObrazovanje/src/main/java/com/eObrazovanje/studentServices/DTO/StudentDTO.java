package com.eObrazovanje.studentServices.DTO;

import com.eObrazovanje.studentServices.entity.Student;

public class StudentDTO {

	public int id;
	public String username;
	public String password;
	public String firstName;
	public String lastName;
	public String email;
	
	public StudentDTO(Student student) {
		this.id = student.getId();
		this.username = student.getUsername();
		this.password = student.getPassword();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();
	}

	public StudentDTO() {
		super();
	}
	
}
