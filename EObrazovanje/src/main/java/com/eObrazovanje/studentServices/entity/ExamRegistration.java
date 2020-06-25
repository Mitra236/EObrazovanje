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
	
	@Column(name = "payment_amount", nullable = false)
	private double paymentAmount;
	
	@Column(name = "registered",nullable = false)
	private boolean registered;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "exam_period", referencedColumnName = "exam_period_id", nullable=false)
	private ExamPeriod exam_period;
	
	@ManyToOne
    @JoinColumn(name = "financial_card", referencedColumnName = "financial_card_id", nullable = false)
	private FinancialCard financial_card;
	
	public ExamRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}
	
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	
	public boolean isRegistered() {
		return registered;
	}
	
	public void setRegistered(boolean registered) {
		this.registered = registered;
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

	public FinancialCard getFinancialCard() {
		return financial_card;
	}

	public void setFinancialCard(FinancialCard financial_card) {
		this.financial_card = financial_card;
	}
	
	
	
}
