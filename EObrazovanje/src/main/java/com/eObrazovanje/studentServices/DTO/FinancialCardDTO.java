package com.eObrazovanje.studentServices.DTO;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.eObrazovanje.studentServices.entity.FinancialCard;

public class FinancialCardDTO {
	
	public int id;
	public Date paymentDate;
	public String paymentDescription;
	public double paymentAmount;

	public FinancialCardDTO() {
		super();
	}

	public FinancialCardDTO(FinancialCard fCard) {
		super();
		this.id = fCard.getId();
		this.paymentDate = fCard.getPaymentDate();
		this.paymentDescription = fCard.getPaymentDescription();
		this.paymentAmount = fCard.getPaymentAmount();
	}
	

}
