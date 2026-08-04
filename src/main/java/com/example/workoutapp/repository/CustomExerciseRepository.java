package com.example.workoutapp.repository;

import com.example.workoutapp.model.CustomExercise;
import com.example.workoutapp.model.enums.BodyPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomExerciseRepository extends JpaRepository<CustomExercise, Long> {
    List<CustomExercise> findByBodyPart(BodyPart bodyPart);
}