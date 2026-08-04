package com.example.workoutapp.dto;

import com.example.workoutapp.model.enums.BodyPart;
import lombok.Data;

@Data
public class WorkoutSummaryDTO {

    private Long workoutId;
    private String exerciseName;
    private BodyPart bodyPart;

    private long durationSeconds;
    private double totalVolume;
    private double averageRestSeconds;

    private double caloriesBurned;
    private double intensityScore;
}