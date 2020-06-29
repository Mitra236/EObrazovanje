package com.eObrazovanje.studentServices.DTO;

import java.sql.Date;

import com.eObrazovanje.studentServices.entity.Enrollment;

public class EnrollmentDTO {
	
	public int id;
	public Date startDate;
	public Date endDate;
	public StudentDTO student;
	
	public EnrollmentDTO() {
		super();
	}
	
	public EnrollmentDTO(Enrollment enrollment) {
		this.id = enrollment.getId();
		this.startDate = enrollment.getStartDate();
		this.endDate = enrollment.getEndDate();
		this.student = new StudentDTO(enrollment.getStudent());
	}

}
