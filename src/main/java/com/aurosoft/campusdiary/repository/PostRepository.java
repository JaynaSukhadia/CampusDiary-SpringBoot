package com.aurosoft.campusdiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurosoft.campusdiary.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
