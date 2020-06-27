package com.eObrazovanje.studentServices.DTO;

import java.sql.Date;

import com.eObrazovanje.studentServices.entity.EExamStatus;
import com.eObrazovanje.studentServices.entity.Exam;

public class ExamDTO {

	public int id;
	public Date date;
	public int examPoints;
	public int labPoints;
	public EExamStatus status;
	public String courseName;
	public String courseProfessor;
	public int studentId;
	
//	public ExamDTO(Exam exam) {
//		super();
//		this.id=exam.getId();
//		this.date = exam.getDate();
//		this.examPoints = exam.getExamPoints();
//		this.labPoints = exam.getLabPoints();
//		this.status=exam.getStatus();
//		this.courseName=exam.getCourse().getName();
//		if(exam.getCourse().getProfessors().size()>0) {
//			this.courseProfessor=exam.getCourse().getProfessors().get(0).getFirstName() + exam.getCourse().getProfessors().get(0).getLastName();
//		}
//		else {
//			this.courseProfessor = "";
//		}
//		this.studentId=exam.getStudent().getId();
//	}
	
}
