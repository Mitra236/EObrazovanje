package com.eObrazovanje.studentServices.DTO;

import java.io.Serializable;

import com.eObrazovanje.studentServices.entity.Professor;

public class ProfessorDataEditDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public int id;
	public String username;
	public String email;
	public String firstName;
	public String lastName;
	public String phoneNumber;
	public String JMBG;
	public String biography;
	
	public ProfessorDataEditDTO() {
		super();
	}
	
	public ProfessorDataEditDTO(Professor professor) {
		this.id = professor.getId();
		this.username = professor.getUsername();
		this.email = professor.getEmail();
		this.firstName = professor.getFirstName();
		this.lastName = professor.getLastName();
		this.phoneNumber = professor.getPhoneNumber();
		this.JMBG = professor.getJMBG();
		this.biography = professor.getBiography();
	}
	
}
