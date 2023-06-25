package com.aurosoft.campusdiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurosoft.campusdiary.entity.CommentPost;

public interface CommentPostRepository extends JpaRepository<CommentPost, Integer>  {

}