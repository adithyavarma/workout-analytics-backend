package com.example.workoutapp.dto;

import com.example.workoutapp.model.enums.BodyPart;
import lombok.Data;

@Data
public class MonthlyProgressDTO {

    private int year;
    private int month;

    private double totalCalories;
    private double averageCaloriesPerDay;

    private double totalVolume;
    private double averageRest;

    private int totalWorkouts;
    private int totalSets;

    private BodyPart mostTrainedBodyPart;
}

