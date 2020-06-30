package com.eObrazovanje.studentServices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.eObrazovanje.studentServices.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

	@Query(value = "SELECT * FROM professors p INNER JOIN professors_courses pc ON p.professor_id = pc.professor_id INNER JOIN courses c ON pc.course_id = c.course_id", nativeQuery = true)
	List<Professor> findAll();
}
