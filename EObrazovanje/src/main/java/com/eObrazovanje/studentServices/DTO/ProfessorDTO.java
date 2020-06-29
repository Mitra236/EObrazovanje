package com.eObrazovanje.studentServices.DTO;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.eObrazovanje.studentServices.entity.ECourseRole;
import com.eObrazovanje.studentServices.entity.EEmplyeeFunction;
import com.eObrazovanje.studentServices.entity.EPosition;
import com.eObrazovanje.studentServices.entity.Professor;

public class ProfessorDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public int id;
	public String firstName;
	public String lastName;
	public String username;
	public String password;
	public String biography;
	public String email;
	public String phoneNumber;
	public String JMBG;
	public String academicTitle;
	public EPosition position;
	public EEmplyeeFunction emplyeeFunction;
	public ECourseRole eCourseRole;
	public Date positionFrom;
	public Date employeeFunctionFrom;
	public List<CourseDTO> courseDTOs;
	
	public ProfessorDTO() {
		super();
	}
	
	public ProfessorDTO(Professor professor) {
		this.id = professor.getId();
		this.academicTitle = professor.getAcademicTitle();
		this.biography = professor.getBiography();
		this.username = professor.getUsername();
		this.firstName = professor.getFirstName();
		this.lastName = professor.getLastName();
		this.JMBG = professor.getJMBG();
		this.password = professor.getPassword();
		this.eCourseRole = professor.getCourseRole();
		this.email = professor.getEmail();
		this.emplyeeFunction = professor.getEmployeeFunction();
		this.position = professor.getPosition();
		this.positionFrom = professor.getPositionFrom();
		this.employeeFunctionFrom = professor.getEmployeeFunctionFrom();
		this.phoneNumber = professor.getPhoneNumber();
		this.courseDTOs = new ArrayList<CourseDTO>();
	}
}
