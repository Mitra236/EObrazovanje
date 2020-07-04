package com.eObrazovanje.studentServices.DTO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.eObrazovanje.studentServices.entity.Exam;

public class ExamDTO {

	public int id;
	public int examPoints;
	public int labPoints;
	public CourseDTO course;
	public Timestamp date;
	public double paymentAmount;
	public List<ExamRegistrationDTO> examRegistrationDTOs;
	
	public ExamDTO(Exam exam) {
		this.id=exam.getId();
		this.examPoints = exam.getExamPoints();
		this.labPoints = exam.getLabPoints();
		this.course = new CourseDTO(exam.getCourse());
		this.date = exam.getExam_date();
		this.paymentAmount = exam.getExamPeriod().getPaymentAmount();
		this.examRegistrationDTOs = new ArrayList<ExamRegistrationDTO>();
	}

	public ExamDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
