package com.example.workoutapp.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Map;

@Data
public class WeeklyCalorieTrendDTO {

    private LocalDate weekStart;
    private LocalDate weekEnd;

    private Map<LocalDate, Double> dailyCalories;

    private double totalWeeklyCalories;
    private double averageDailyCalories;
}

