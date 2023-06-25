package com.aurosoft.campusdiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurosoft.campusdiary.entity.Staff;

public interface StaffRepository extends JpaRepository<Staff,Integer> {

}
