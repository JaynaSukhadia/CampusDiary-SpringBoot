package com.aurosoft.campusdiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurosoft.campusdiary.entity.Suggestion;

public interface SuggestionRepository extends JpaRepository<Suggestion, Integer>{

}
