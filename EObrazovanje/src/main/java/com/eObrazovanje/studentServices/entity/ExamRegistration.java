package com.eObrazovanje.studentServices.entity;

import java.io.Serializable;

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
@Table(name = "exam_registrations")
public class ExamRegistration implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "exam_registration_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "status", nullable = false)
	private EExamStatus status;
	
	@Column(name = "final_grade",nullable = true)
	private int finalGrade;
	
	@Column(name = "checked", nullable = true)
	private boolean checked;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "exam_period", referencedColumnName = "exam_period_id", nullable=false)
	private ExamPeriod exam_period;
	
	@ManyToOne
	@JoinColumn(name = "student", referencedColumnName = "student_id", nullable=false)
	private Student student;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "exam", referencedColumnName = "exam_id", nullable=false)
	private Exam exam;
	
	public ExamRegistration() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public ExamPeriod getExamPeriod() {
		return exam_period;
	}

	public void setExamPeriod(ExamPeriod examPeriod) {
		this.exam_period = examPeriod;
	}

	public EExamStatus getStatus() {
		return status;
	}

	public void setStatus(EExamStatus status) {
		this.status = status;
	}

	public int getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(int finalGrade) {
		this.finalGrade = finalGrade;
	}

	public ExamPeriod getExam_period() {
		return exam_period;
	}

	public void setExam_period(ExamPeriod exam_period) {
		this.exam_period = exam_period;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
