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
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id", nullable = false)
	private int id;
	
	@Column(name = "course_name", unique = true, nullable = false)
	private String name;
	
	@Column(name = "course_code", unique = true, nullable = false)
	private String courseCode;
	
	@Column(name = "ECTS", nullable = false)
	private int ECTS;
	
	@Column(name = "lectures", nullable = false)
	private int lectures;
	
	@Column(name = "practical_classes", nullable = false)
	private int practicalCLasses;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "course")
	private List<Exam> exams = new ArrayList<Exam>();
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable( name = "professors_courses", joinColumns = @JoinColumn(name = "course_id") ,inverseJoinColumns = @JoinColumn(name = "professor_id") )
	private List<Professor> professors = new ArrayList<>();
	
	@ManyToOne
    @JoinColumn(name = "study_programme_courses", referencedColumnName = "study_programme_id", nullable = false)
	private StudyProgramme study_programme_courses;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "course")
	private List<Enrollment> enrollments = new ArrayList<Enrollment>();
	
	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Course() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public int getECTS() {
		return ECTS;
	}

	public void setECTS(int eCTS) {
		ECTS = eCTS;
	}

	public int getLectures() {
		return lectures;
	}

	public void setLectures(int lectures) {
		this.lectures = lectures;
	}

	public int getPracticalCLasses() {
		return practicalCLasses;
	}

	public void setPracticalCLasses(int practicalCLasses) {
		this.practicalCLasses = practicalCLasses;
	}

	public List<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	public StudyProgramme getStudyProgramme() {
		return study_programme_courses;
	}

	public void setStudyProgramme(StudyProgramme studyProgramme) {
		this.study_programme_courses = studyProgramme;
	}

	public List<Enrollment> getEnrollment() {
		return enrollments;
	}

	public void setEnrollment(List<Enrollment> enrollment) {
		this.enrollments = enrollment;
	}

}
