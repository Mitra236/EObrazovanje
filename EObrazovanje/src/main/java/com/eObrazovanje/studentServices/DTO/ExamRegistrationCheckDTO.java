package com.eObrazovanje.studentServices.DTO;

import java.io.Serializable;
import java.sql.Timestamp;

import com.eObrazovanje.studentServices.entity.EExamStatus;
import com.eObrazovanje.studentServices.entity.ExamRegistration;

public class ExamRegistrationCheckDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public int id;
	public String courseName;
	public StudentDTO student;
	public String courseProfessor;
	public int finalGrade;
	public EExamStatus status;
	public boolean check;
	public Timestamp date;
	
	public ExamRegistrationCheckDTO() {
		super();
	}

	public ExamRegistrationCheckDTO(ExamRegistration examRegistration) {
		this.id = examRegistration.getId();
		this.courseName = examRegistration.getExam().getCourse().getName();
		this.student = new StudentDTO(examRegistration.getStudent());
		if(examRegistration.getExam().getCourse().getProfessors().size()>0) {
			this.courseProfessor=examRegistration.getExam().getCourse().getProfessors().get(0).getFirstName() + " " + examRegistration.getExam().getCourse().getProfessors().get(0).getLastName();
		}
		else {
			this.courseProfessor = "";
		}
		this.finalGrade = examRegistration.getFinalGrade();
		this.status = examRegistration.getStatus();
		this.check = examRegistration.isChecked();
		this.date = examRegistration.getExam().getExam_date();
	}
}
