package com.eObrazovanje.studentServices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eObrazovanje.studentServices.entity.StudentDocs;
import com.eObrazovanje.studentServices.repository.StudentDocsRepository;

@Service
public class StudentDocsService implements StudentDocsServiceInterface{
	
	@Autowired
	StudentDocsRepository studentDocsRepository;

	@Override
	public StudentDocs findOne(int id) {
		// TODO Auto-generated method stub
		return studentDocsRepository.findById(id).orElse(null);
	}

	@Override
	public List<StudentDocs> findAll() {
		// TODO Auto-generated method stub
		return studentDocsRepository.findAll();
		
	}

	@Override
	public int save(StudentDocs studentDocs) {
		// TODO Auto-generated method stub
		return studentDocsRepository.save(studentDocs).getId();
	}

}
