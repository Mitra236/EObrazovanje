package com.eObrazovanje.studentServices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eObrazovanje.studentServices.entity.Student;
import com.eObrazovanje.studentServices.repository.StudentRepository;

@Service
public class StudentService implements StudentServiceInterface {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student findOne(int id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).orElse(null);
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public int save(Student valuta) {
		// TODO Auto-generated method stub
		return studentRepository.save(valuta).getId();
	}

}
