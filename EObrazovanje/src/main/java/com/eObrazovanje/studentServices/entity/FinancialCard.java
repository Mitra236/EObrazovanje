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
@Table(name = "financial_cards")
public class FinancialCard implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "financial_card_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "financial_card_payment_date", unique = false, nullable = false)
	private Date paymentDate;
	
	@Column(name = "financial_card_payment_description", unique = false, nullable = false)
	private String paymentDescription;

	@Column(name = "financial_card_payment_amount", unique = false, nullable = false)
	private double paymentAmount;
	
	@Column(name = "financial_card_payment_exception", unique = false, nullable = false)
	private double paymentException;
	
	@Column(name = "financial_card_initial_state", unique = false, nullable = false)
	private double initialState;
	
	@Column(name = "financial_card_total_payment", unique = false, nullable = false)
	private double totalPayment;
	
	@Column(name = "financial_card_total_cost", unique = false, nullable = false)
	private double totalCost;
	
	@ManyToOne
    @JoinColumn(name = "student_financial_card", referencedColumnName = "student_id", nullable = false)
	private Student student_financial_card;

	public FinancialCard() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentDescription() {
		return paymentDescription;
	}

	public void setPaymentDescription(String paymentDescription) {
		this.paymentDescription = paymentDescription;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public double getPaymentException() {
		return paymentException;
	}

	public void setPaymentException(double paymentException) {
		this.paymentException = paymentException;
	}

	public double getInitialState() {
		return initialState;
	}

	public void setInitialState(double initialState) {
		this.initialState = initialState;
	}

	public double getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(double totalPayment) {
		this.totalPayment = totalPayment;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public Student getStudent() {
		return student_financial_card;
	}

	public void setStudent(Student studentFinancialCard) {
		this.student_financial_card = studentFinancialCard;
	}

}
