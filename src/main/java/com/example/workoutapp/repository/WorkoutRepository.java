package com.example.workoutapp.repository;

import com.example.workoutapp.model.Workout;
import com.example.workoutapp.model.enums.BodyPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    List<Workout> findByDateBetween(LocalDate start, LocalDate end);

    List<Workout> findByDate(LocalDate date);

    List<Workout> findByBodyPart(BodyPart bodyPart);
}