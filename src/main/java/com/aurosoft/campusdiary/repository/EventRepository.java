package com.aurosoft.campusdiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurosoft.campusdiary.entity.Event;

public interface EventRepository extends JpaRepository<Event,Integer>{

}
