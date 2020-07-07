package com.eObrazovanje.studentServices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.eObrazovanje.studentServices.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	@Query(value = "SELECT c.course_id, c.course_name, c.ects, c.course_code, c.lectures, c.practical_classes, c.study_programme_courses FROM professors p INNER JOIN professors_courses pc ON p.professor_id = pc.professor_id INNER JOIN courses c ON pc.course_id = c.course_id WHERE p.professor_id = ?", nativeQuery = true)
	List<Course> findProfessorCourses(int id);
	
}
