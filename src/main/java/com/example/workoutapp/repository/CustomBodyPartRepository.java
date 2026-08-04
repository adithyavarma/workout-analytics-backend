package com.example.workoutapp.repository;

import com.example.workoutapp.model.CustomBodyPart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomBodyPartRepository extends JpaRepository<CustomBodyPart, Long> {}
