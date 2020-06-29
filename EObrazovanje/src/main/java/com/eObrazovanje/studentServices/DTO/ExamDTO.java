package com.eObrazovanje.studentServices.DTO;

import java.sql.Timestamp;

import com.eObrazovanje.studentServices.entity.Exam;

public class ExamDTO {

	public int id;
	public int examPoints;
	public int labPoints;
	public CourseDTO course;
	public Timestamp date;
	public double paymentAmount;
	
	public ExamDTO(Exam exam) {
		this.id=exam.getId();
		this.examPoints = exam.getExamPoints();
		this.labPoints = exam.getLabPoints();
		this.course = new CourseDTO(exam.getCourse());
		this.date = exam.getExam_date();
		this.paymentAmount = exam.getExamPeriod().getPaymentAmount();
	}

	public ExamDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
