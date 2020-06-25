package com.eObrazovanje.studentServices.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exams")
public class Exam implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "exam_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "exam_points", nullable = false)
	private int examPoints;
	
	@Column(name = "lab_points", nullable = false)
	private int labPoints;
	
	@Column(name = "course_date", nullable = false)
	private Date date;
	
	@Column(name = "ND", nullable = false)
	private boolean ND;
	
	@ManyToOne
    @JoinColumn(name = "course", referencedColumnName = "course_id", nullable=false)
	private Course course;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "period", referencedColumnName = "exam_period_id", nullable=false)
	private ExamPeriod period;
	
	@ManyToOne
    @JoinColumn(name = "student", referencedColumnName = "student_id", nullable=true)
	private Student student;
	
//	private Professor professor;
	
	public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getExamPoints() {
		return examPoints;
	}

	public void setExamPoints(int examPoints) {
		this.examPoints = examPoints;
	}

	public int getLabPoints() {
		return labPoints;
	}

	public void setLabPoints(int labPoints) {
		this.labPoints = labPoints;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isND() {
		return ND;
	}

	public void setND(boolean nD) {
		ND = nD;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
//
//	public Professor getProfessor() {
//		return professor;
//	}
//
//	public void setProfessor(Professor professor) {
//		this.professor = professor;
//	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public ExamPeriod getExamPeriod() {
		return period;
	}

	public void setExamPeriod(ExamPeriod examPeriod) {
		this.period = examPeriod;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
