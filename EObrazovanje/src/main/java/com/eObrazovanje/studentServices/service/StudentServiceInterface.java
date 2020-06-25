package com.eObrazovanje.studentServices.service;

import java.util.List;

import com.eObrazovanje.studentServices.entity.Admin;
import com.eObrazovanje.studentServices.entity.Student;

public interface StudentServiceInterface {

	Student findOne(int id);
	List<Student> findAll();
	int save(Student valuta);
}
