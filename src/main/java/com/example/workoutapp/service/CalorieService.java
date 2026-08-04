package com.example.workoutapp.service;

import com.example.workoutapp.model.Workout;
import com.example.workoutapp.model.WorkoutSet;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CalorieService {

    public double calculateCalories(
            double met,
            double weightKg,
            long durationSeconds
    )
    {
        double durationMinutes = durationSeconds / 60.0;

        return (met * 3.5 * weightKg * durationMinutes) / 200.0;
    }

    public double calculateCaloriesForWorkout(Workout workout, double weightKg) {

        double met = workout.getExerciseType().getMet();
        long durationSeconds = workout.getTotalDurationSeconds();

        return calculateCalories(met, weightKg, durationSeconds);
    }

    public double calculateCaloriesForSet(WorkoutSet set, double weightKg, double met) {

        long estimatedSetSeconds = set.getReps() * 2; // default assumption

        return calculateCalories(met, weightKg, estimatedSetSeconds);
    }
}
