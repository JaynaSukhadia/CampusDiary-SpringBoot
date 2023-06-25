package com.aurosoft.campusdiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurosoft.campusdiary.entity.EventRegistration;

public interface EventRegistrationRepository extends JpaRepository<EventRegistration,Integer> {

}
