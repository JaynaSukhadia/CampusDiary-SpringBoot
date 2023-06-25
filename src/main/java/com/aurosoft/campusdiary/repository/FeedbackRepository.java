package com.aurosoft.campusdiary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurosoft.campusdiary.entity.Feedback;

public interface FeedbackRepository  extends JpaRepository<Feedback,Integer>{
	
	List<Feedback> findByName(String name);

}
