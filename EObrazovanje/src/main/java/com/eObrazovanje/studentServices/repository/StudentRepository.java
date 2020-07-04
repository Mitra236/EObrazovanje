package com.eObrazovanje.studentServices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eObrazovanje.studentServices.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	@Query(value = "SELECT * FROM students AS s WHERE s.student_id NOT IN (SELECT DISTINCT e.student FROM enrollments e WHERE e.student = s.student_id AND e.course = ?)", nativeQuery = true)
	List<Student> getNotEnrolledStudents(int id);
}
