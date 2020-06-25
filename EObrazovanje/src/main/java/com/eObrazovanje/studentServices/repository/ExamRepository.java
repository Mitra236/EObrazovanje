package com.eObrazovanje.studentServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eObrazovanje.studentServices.entity.Exam;

public interface ExamRepository extends JpaRepository<Exam, Integer>{

}
