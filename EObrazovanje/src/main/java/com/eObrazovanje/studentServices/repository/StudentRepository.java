package com.eObrazovanje.studentServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eObrazovanje.studentServices.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
