package com.example.workoutapp.dto;

import com.example.workoutapp.model.enums.BodyPart;
import lombok.Data;

@Data
public class BodyPartCaloriesDTO {
    private BodyPart bodyPart;
    private double caloriesBurned;
}

