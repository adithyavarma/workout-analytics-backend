package com.example.workoutapp.dto;

import lombok.Data;

@Data
public class DashboardDTO {

    private double todayCalories;
    private double weeklyCalories;
    private double monthlyCalories;

    private WorkoutSummaryDTO lastWorkoutSummary;
}

