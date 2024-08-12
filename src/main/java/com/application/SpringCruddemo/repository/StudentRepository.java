package com.application.SpringCruddemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.SpringCruddemo.domain.Student;
import com.application.SpringCruddemo.domain.Student;  


@Repository

public interface StudentRepository extends JpaRepository<Student, Long> {
}