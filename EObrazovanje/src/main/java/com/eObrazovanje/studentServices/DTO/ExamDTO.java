package com.eObrazovanje.studentServices.DTO;

import com.eObrazovanje.studentServices.entity.Exam;

public class ExamDTO {

	public int id;
	public int examPoints;
	public int labPoints;
	public CourseDTO courseName;
	
	public ExamDTO(Exam exam) {
		this.id=exam.getId();
		this.examPoints = exam.getExamPoints();
		this.labPoints = exam.getLabPoints();
		this.courseName = new CourseDTO(exam.getCourse());
	}

	public ExamDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
