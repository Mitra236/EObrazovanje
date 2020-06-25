package com.eObrazovanje.studentServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eObrazovanje.studentServices.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
