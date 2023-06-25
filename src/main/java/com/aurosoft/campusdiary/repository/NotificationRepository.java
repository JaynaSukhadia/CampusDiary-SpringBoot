package com.aurosoft.campusdiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurosoft.campusdiary.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer>{

	 
}
