package com.eObrazovanje.studentServices.DTO;

import com.eObrazovanje.studentServices.entity.EMethodOfFinancing;
import com.eObrazovanje.studentServices.entity.Student;

public class StudentDetailsDTO {

	public int id;
	public String index;
	public String username;
	public String password;
	public String firstName;
	public String lastName;
	public String email;
	public String phone;
	public String JMBG;
	public String giroAccountNumber;
	public int yearOfEnrollment;
	public EMethodOfFinancing methodOfFinancing;
	public int yearOfStudy;
	public int timeEnrolled;
	public String modelNumber;
	public String personalReferenceNumber;
	public double accountBalance;
	public int studyProgrammeId;
	
	public StudentDetailsDTO(Student student) {
		super();
		this.id = student.getId();
		this.index= student.getIndex();
		this.username = student.getUsername();
		this.password = student.getPassword();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();
		this.phone = student.getPhoneNumber();
		this.JMBG = student.getJMBG();
		this.giroAccountNumber = student.getGiroAccountNumber();
		this.yearOfEnrollment = student.getYearOfEnrollment();
		this.methodOfFinancing = student.getMethodOfFinancing();
		this.yearOfStudy = student.getYearOfStudy();
		this.timeEnrolled  =student.getTimeEnrolled();
		this.modelNumber = student.getModelNumber();
		this.personalReferenceNumber = student.getPersonalReferenceNumber();
		this.accountBalance = student.getAccountBalance();
		this.studyProgrammeId = student.getStudyProgramme().getId();
	}
}
