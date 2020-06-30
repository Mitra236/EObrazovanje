package com.eObrazovanje.studentServices.DTO;

import java.io.Serializable;
import java.sql.Date;

import com.eObrazovanje.studentServices.entity.EExamPeriodName;
import com.eObrazovanje.studentServices.entity.ExamPeriod;

public class ExamPeriodDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public int id;
	public EExamPeriodName examPeriodName;
	public Date startDate;
	public Date endDate;
	
	public ExamPeriodDTO() {
		super();
	}
	
	public ExamPeriodDTO(ExamPeriod examPeriod) {
		this.id = examPeriod.getId();
		this.examPeriodName = examPeriod.getExamName();
		this.startDate = examPeriod.getStartDate();
		this.endDate = examPeriod.getEndDate();
	}

}
