package com.eObrazovanje.studentServices.DTO;

import java.sql.Date;

import com.eObrazovanje.studentServices.entity.Enrollment;

public class EnrollmentToAddDTO {

	public int id;
	public Date startDate;
	public Date endDate;
	public int student;
	public int course;
	
	public EnrollmentToAddDTO() {
		super();
	}
	
	public EnrollmentToAddDTO(Enrollment enrollment) {
		this.id = enrollment.getId();
		this.startDate = enrollment.getStartDate();
		this.endDate = enrollment.getEndDate();
		this.student = enrollment.getStudent().getId();
		this.course = enrollment.getStudent().getId();
	}

}
