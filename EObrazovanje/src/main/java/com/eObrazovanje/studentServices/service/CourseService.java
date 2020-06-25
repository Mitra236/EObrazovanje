package com.eObrazovanje.studentServices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eObrazovanje.studentServices.entity.Course;
import com.eObrazovanje.studentServices.repository.CourseRepository;

@Service
public class CourseService implements CourseServiceInterface{
	
	@Autowired
	CourseRepository courseRepo;

	@Override
	public Course findOne(int id) {
		return courseRepo.findById(id).orElse(null);
	}

	@Override
	public List<Course> findAll() {
		return courseRepo.findAll();
	}

	@Override
	public int save(Course course) {
		return courseRepo.save(course).getId();
	}

	@Override
	public boolean remove(int id) {
		courseRepo.deleteById(id);
		return true;
	}

}
