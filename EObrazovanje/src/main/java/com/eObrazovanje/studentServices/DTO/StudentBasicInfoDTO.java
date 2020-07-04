package com.eObrazovanje.studentServices.DTO;

import java.io.Serializable;

import com.eObrazovanje.studentServices.entity.Student;

public class StudentBasicInfoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public int id;
	public String firstName;
	public String lastName;
	
	public StudentBasicInfoDTO() {
		super();
	}

	public StudentBasicInfoDTO(Student student) {
		this.id = student.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
	}
}
