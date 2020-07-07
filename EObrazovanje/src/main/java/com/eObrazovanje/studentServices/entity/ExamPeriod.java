package com.eObrazovanje.studentServices.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "exam_periods")
public class ExamPeriod implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "exam_period_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "exam_name", unique = true, nullable = false)
	private EExamPeriodName examName;
	
	@Column(name = "start_date", nullable = false)
	private Date startDate;
	
	@Column(name = "end_date", nullable = false)
	private Date endDate;
	
	@Column(name = "payment_amount", nullable = false) 
	private double paymentAmount;
	
	@OneToMany(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY, mappedBy = "period")
	private List<Exam> examsTaken = new ArrayList<Exam>();
	
	@OneToMany(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY, mappedBy = "exam_period")
	private List<ExamRegistration> examsRegistered = new ArrayList<ExamRegistration>();
	
	public ExamPeriod() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EExamPeriodName getExamName() {
		return examName;
	}

	public void setExamName(EExamPeriodName examName) {
		this.examName = examName;
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

	public int getId() {
		return id;
	}

	public List<Exam> getExams() {
		return examsTaken;
	}

	public void setExams(List<Exam> exams) {
		this.examsTaken = exams;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<ExamRegistration> getExamsRegistered() {
		return examsRegistered;
	}

	public void setExamsRegistered(List<ExamRegistration> examsRegistered) {
		this.examsRegistered = examsRegistered;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public List<Exam> getExamsTaken() {
		return examsTaken;
	}

	public void setExamsTaken(List<Exam> examsTaken) {
		this.examsTaken = examsTaken;
	}

	public void setId(int id) {
		this.id = id;
	}

}
