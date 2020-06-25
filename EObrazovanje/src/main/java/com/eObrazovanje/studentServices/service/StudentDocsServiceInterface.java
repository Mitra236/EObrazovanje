package com.eObrazovanje.studentServices.service;

import java.util.List;
import com.eObrazovanje.studentServices.entity.StudentDocs;


public interface StudentDocsServiceInterface {

	StudentDocs findOne(int id);
	List<StudentDocs> findAll();
	int save(StudentDocs studentDocs);
}
