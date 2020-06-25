package com.eObrazovanje.studentServices.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id", unique = true, nullable = false)
	private int id;

	@Column(name = "student_username", unique = true, nullable = false)
	private String username;

	@Column(name = "student_password", unique = false, nullable = false)
	private String password;
	
	@Column(name = "student_index", unique = true, nullable = false)
	private String index;

	@Column(name = "student_first_name", unique = false, nullable = false)
	private String firstName;

	@Column(name = "student_last_name", unique = false, nullable = false)
	private String lastName;

	@Column(name = "student_email", unique = true, nullable = true)
	private String email;

	@Column(name = "student_phone", unique = false, nullable = true)
	private String phoneNumber;

	@Column(name = "student_JMBG", unique = true, nullable = false, length = 13)
	private String JMBG;

//	@Column(name = "student_programme", unique = false, nullable = false)
//	private StudyProgramme studyProgramme;

	@Column(name = "student_enrollment_year", unique = false, nullable = false)
	private int yearOfEnrollment;

	@Column(name = "student_financing", unique = false, nullable = false)
	private EMethodOfFinancing methodOfFinancing;

	@Column(name = "student_year_of_study", unique = false, nullable = false)
	private int yearOfStudy;

	@Column(name = "student_time_enrolled", unique = false, nullable = false)
	private int timeEnrolled;

	@Column(name = "student_giro", unique = false, nullable = false)
	private String giroAccountNumber;

	@Column(name = "student_model_number", unique = false, nullable = true)
	private String modelNumber;

	@Column(name = "student_personal_refernce_number", unique = true, nullable = false)
	private String personalReferenceNumber;

	@Column(name = "student_balance", unique = false, nullable = false)
	private double accountBalance;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "student")
	private List<Exam> examsTaken = new ArrayList<Exam>();
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "student_financial_card")
	private List<FinancialCard> studentsFinCard = new ArrayList<FinancialCard>();
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "student_docs")
	private List<StudentDocs> studentsDocs = new ArrayList<StudentDocs>();
	
	@ManyToOne
    @JoinColumn(name = "study_programme", referencedColumnName = "study_programme_id", nullable = false)
	private StudyProgramme study_programme;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "student_enrollment")
	private List<Enrollment> studentEnrollments = new ArrayList<Enrollment>();
	
	public Student() {
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

	public int getYearOfEnrollment() {
		return yearOfEnrollment;
	}

	public void setYearOfEnrollment(int yearOfEnrollment) {
		this.yearOfEnrollment = yearOfEnrollment;
	}

	public EMethodOfFinancing getMethodOfFinancing() {
		return methodOfFinancing;
	}

	public void setMethodOfFinancing(EMethodOfFinancing methodOfFinancing) {
		this.methodOfFinancing = methodOfFinancing;
	}

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public int getTimeEnrolled() {
		return timeEnrolled;
	}

	public void setTimeEnrolled(int timeEnrolled) {
		this.timeEnrolled = timeEnrolled;
	}

	public String getGiroAccountNumber() {
		return giroAccountNumber;
	}

	public void setGiroAccountNumber(String giroAccountNumber) {
		this.giroAccountNumber = giroAccountNumber;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public String getPersonalReferenceNumber() {
		return personalReferenceNumber;
	}

	public void setPersonalReferenceNumber(String personalReferenceNumber) {
		this.personalReferenceNumber = personalReferenceNumber;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public List<Exam> getExamsTaken() {
		return examsTaken;
	}

	public void setExamsTaken(List<Exam> examsTaken) {
		this.examsTaken = examsTaken;
	}

	public List<FinancialCard> getFinancialCard() {
		return studentsFinCard;
	}

	public void setFinancialCard(List<FinancialCard> studentsFinCard) {
		this.studentsFinCard = studentsFinCard;
	}

	public List<StudentDocs> getStudentDocs() {
		return studentsDocs;
	}

	public void setStudentDocs(List<StudentDocs> studentsDocs) {
		this.studentsDocs = studentsDocs;
	}

	public StudyProgramme getStudyProgramme() {
		return study_programme;
	}

	public void setStudyProgramme(StudyProgramme studyProgramme) {
		this.study_programme = studyProgramme;
	}

	public List<Enrollment> getEnrollment() {
		return studentEnrollments;
	}

	public void setEnrollment(List<Enrollment> studentEnrollments) {
		this.studentEnrollments = studentEnrollments;
	}
	
	
	
}
