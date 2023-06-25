package com.aurosoft.campusdiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurosoft.campusdiary.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
