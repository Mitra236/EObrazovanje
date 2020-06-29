package com.eObrazovanje.studentServices.DTO;

import com.eObrazovanje.studentServices.entity.EExamStatus;
import com.eObrazovanje.studentServices.entity.ExamRegistration;

public class ExamPointsDTO {

	public int id;
	public EExamStatus status;
	public int finalGrade;
	public ExamDTO exam;
	
	public ExamPointsDTO() {
		super();
	}
	
	public ExamPointsDTO(ExamRegistration examReg) {
		this.id = examReg.getId();
		this.status = examReg.getStatus();
		this.finalGrade = examReg.getFinalGrade();
		this.exam = new ExamDTO(examReg.getExam());
	}
}
