package com.example.workoutapp.service;

import com.example.workoutapp.model.CustomExercise;
import com.example.workoutapp.model.Exercise;
import com.example.workoutapp.model.enums.BodyPart;
import com.example.workoutapp.model.enums.ExerciseType;
import com.example.workoutapp.repository.CustomExerciseRepository;
import com.example.workoutapp.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ExerciseService {

    private final CustomExerciseRepository customRepo;

    public ExerciseService(CustomExerciseRepository customRepo) {
        this.customRepo = customRepo;
    }

    // Built‑in exercises (enum dropdown)
    public List<ExerciseType> getBuiltInByBodyPart(BodyPart bodyPart) {
        return Arrays.stream(ExerciseType.values())
                .filter(e -> e.getBodyPart() == bodyPart)
                .toList();
    }

    // Add custom exercise
    public CustomExercise addCustom(CustomExercise e) {
        return customRepo.save(e);
    }

    // Get all custom exercises
    public List<CustomExercise> getCustomByBodyPart(BodyPart bodyPart) {
        return customRepo.findByBodyPart(bodyPart);
    }
}