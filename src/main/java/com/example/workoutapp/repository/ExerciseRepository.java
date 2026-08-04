package com.example.workoutapp.repository;

import com.example.workoutapp.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
