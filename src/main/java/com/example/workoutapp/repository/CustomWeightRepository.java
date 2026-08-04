package com.example.workoutapp.repository;

import com.example.workoutapp.model.CustomWeight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomWeightRepository extends JpaRepository<CustomWeight, Long> {
}