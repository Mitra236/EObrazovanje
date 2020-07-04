package com.eObrazovanje.studentServices.DTO;

import com.eObrazovanje.studentServices.entity.ExamRegistration;

public class ExamPointsDTO {

	public int id;
	public int finalGrade;
	public int examPoints;
	public int labPoints;
	
	public ExamPointsDTO() {
		super();
	}
	
	public ExamPointsDTO(ExamRegistration examReg) {
		this.id = examReg.getId();
		this.finalGrade = examReg.getFinalGrade();
		this.examPoints = examReg.getExam().getExamPoints();
		this.labPoints = examReg.getExam().getLabPoints();
	}
}
