package com.eObrazovanje.studentServices.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

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
	
	@Column(name = "exam_date", nullable = false)
	private Timestamp exam_date;
	
	@Column(name = "class_room", nullable = false)
	private String classRoom;
	
	@ManyToOne
    @JoinColumn(name = "course", referencedColumnName = "course_id", nullable=false)
	private Course course;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "period", referencedColumnName = "exam_period_id", nullable=false)
	private ExamPeriod period;
	
	@OneToMany(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY, mappedBy = "exam")
	private java.util.List<ExamRegistration> examRegistrations = new ArrayList<ExamRegistration>();
	
	public Exam() {
		super();
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
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

	public ExamPeriod getPeriod() {
		return period;
	}

	public void setPeriod(ExamPeriod period) {
		this.period = period;
	}

	public Timestamp getExam_date() {
		return exam_date;
	}

	public void setExam_date(Timestamp exam_date) {
		this.exam_date = exam_date;
	}

	public String getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}

	public java.util.List<ExamRegistration> getExamRegistrations() {
		return examRegistrations;
	}

	public void setExamRegistrations(java.util.List<ExamRegistration> examRegistrations) {
		this.examRegistrations = examRegistrations;
	}

}
