package com.eObrazovanje.studentServices.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "professors")
public class Professor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "professor_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "professor_username", unique = true, nullable = false)
	private String username;

	@Column(name = "professor_password", unique = false, nullable = false)
	private String password;

	@Column(name = "professor_first_name", unique = false, nullable = false)
	private String firstName;

	@Column(name = "professor_last_name", unique = false, nullable = false)
	private String lastName;

	@Column(name = "professor_email", unique = true, nullable = false)
	private String email;

	@Column(name = "professor_phone", unique = false, nullable = true)
	private String phoneNumber;

	@Column(name = "professor_JMBG", unique = true, nullable = true, length = 13)
	private String JMBG;

	@Column(name = "professor_title", unique = false, nullable = true)
	private String academicTitle;

	@Column(name = "professor_biography", unique = false, nullable = true)
	private String biography;

	@Column(name = "professor_position", unique = false, nullable = true)
	private EPosition position;
	
	@Column(name = "professor_function", unique = false, nullable = true)
	private EEmplyeeFunction employeeFunction;
	
	@Column(name = "professor_course_role", unique = false, nullable = true)
	private ECourseRole courseRole;
	
	@Column(name = "professor_position_from", unique = false, nullable = true)
	private Date positionFrom;
	
	@Column(name = "professor_function_from", unique = false, nullable = true)
	private Date employeeFunctionFrom;
	
	@ManyToMany(mappedBy = "professors")
    private List<Course> courses = new ArrayList<>();
	
	public Professor() {
		super();
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getJMBG() {
		return JMBG;
	}

	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}

	public String getAcademicTitle() {
		return academicTitle;
	}

	public void setAcademicTitle(String academicTitle) {
		this.academicTitle = academicTitle;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public EPosition getPosition() {
		return position;
	}

	public void setPosition(EPosition position) {
		this.position = position;
	}

	public EEmplyeeFunction getEmployeeFunction() {
		return employeeFunction;
	}

	public void setEmployeeFunction(EEmplyeeFunction employeeFunction) {
		this.employeeFunction = employeeFunction;
	}

	public ECourseRole getCourseRole() {
		return courseRole;
	}

	public void setCourseRole(ECourseRole courseRole) {
		this.courseRole = courseRole;
	}

	public Date getPositionFrom() {
		return positionFrom;
	}

	public void setPositionFrom(Date positionFrom) {
		this.positionFrom = positionFrom;
	}

	public Date getEmployeeFunctionFrom() {
		return employeeFunctionFrom;
	}

	public void setEmployeeFunctionFrom(Date employeeFunctionFrom) {
		this.employeeFunctionFrom = employeeFunctionFrom;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}
