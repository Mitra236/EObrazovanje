package com.eObrazovanje.studentServices.DTO;

import java.io.Serializable;

import com.eObrazovanje.studentServices.entity.EExamPeriodName;
import com.eObrazovanje.studentServices.entity.Exam;

public class ExamAdminDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public int id;
	public CourseDTO course;
	public java.sql.Timestamp date;
	public String classroom;
	public String period;
	
	public ExamAdminDTO() {
		super();
	}

	public ExamAdminDTO (Exam exam) {
		this.id = exam.getId();
		this.course = new CourseDTO(exam.getCourse());
		this.period = exam.getExamPeriod().getExamName().toString();
		this.date = exam.getExam_date();
		this.classroom = exam.getClassRoom();
	}

}
