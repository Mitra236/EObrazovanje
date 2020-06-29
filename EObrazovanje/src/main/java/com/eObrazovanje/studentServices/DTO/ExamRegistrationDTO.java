package com.eObrazovanje.studentServices.DTO;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import com.eObrazovanje.studentServices.entity.EExamStatus;
import com.eObrazovanje.studentServices.entity.ExamRegistration;

public class ExamRegistrationDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public int id;
	public Timestamp date;
	public int examPoints;
	public int labPoints;
	public EExamStatus status;
	public String courseName;
	public String courseProfessor;
	public int studentId;
	public int ECTS;
	public int finalGrade;
	
	public ExamRegistrationDTO(ExamRegistration examReg) {
		super();
		this.id=examReg.getId();
		this.date = examReg.getExam().getExam_date();
		this.examPoints = examReg.getExam().getExamPoints();
		this.labPoints = examReg.getExam().getLabPoints();
		this.status=examReg.getStatus();
		this.courseName=examReg.getExam().getCourse().getName();
		if(examReg.getExam().getCourse().getProfessors().size()>0) {
			this.courseProfessor=examReg.getExam().getCourse().getProfessors().get(0).getFirstName() + examReg.getExam().getCourse().getProfessors().get(0).getLastName();
		}
		else {
			this.courseProfessor = "";
		}
		this.studentId=examReg.getStudent().getId();
		this.ECTS = examReg.getExam().getCourse().getECTS();
		this.finalGrade = examReg.getFinalGrade();
	}

}
