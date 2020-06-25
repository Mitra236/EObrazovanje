package com.eObrazovanje.studentServices.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "enrollments")
public class Enrollment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "enrollment_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "enrollment_start_date", unique = false, nullable = true)
	private Date startDate;

	@Column(name = "enrollment_end_date", unique = false, nullable = true)
	private Date endDate;
	
	@ManyToOne
    @JoinColumn(name = "student", referencedColumnName = "student_id", nullable = false)
	private Student student_enrollment;
	
	@ManyToOne
    @JoinColumn(name = "course", referencedColumnName = "course_id", nullable = false)
	private Course course;

	public Enrollment() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Student getStudent() {
		return student_enrollment;
	}

	public void setStudent(Student student) {
		this.student_enrollment = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
}
