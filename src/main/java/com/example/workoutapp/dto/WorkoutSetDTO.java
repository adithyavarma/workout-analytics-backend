package com.example.workoutapp.dto;

import lombok.Data;

@Data
public class WorkoutSetDTO {
    private Double weight;
    private Integer reps;
    private Long restSeconds;
}
