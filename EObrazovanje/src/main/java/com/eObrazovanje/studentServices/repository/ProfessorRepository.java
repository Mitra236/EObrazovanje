package com.eObrazovanje.studentServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eObrazovanje.studentServices.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
