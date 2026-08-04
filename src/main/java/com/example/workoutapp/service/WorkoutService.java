package com.example.workoutapp.service;

import com.example.workoutapp.model.CustomExercise;
import com.example.workoutapp.model.Workout;
import com.example.workoutapp.model.enums.ExerciseType;
import com.example.workoutapp.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class WorkoutService {

    private final WorkoutRepository repo;

    public WorkoutService(WorkoutRepository repo) {
        this.repo = repo;
    }

    // CREATE WORKOUT
    public Workout createWorkout(Workout workout) {

        validateWorkout(workout);

        return repo.save(workout);
    }

    // UPDATE WORKOUT
    public Workout updateWorkout(Long id, Workout updated) {

        Workout existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Workout not found"));

        validateWorkout(updated);

        existing.setBodyPart(updated.getBodyPart());
        existing.setExerciseType(updated.getExerciseType());
        existing.setCustomExercise(updated.getCustomExercise());
        existing.setDate(updated.getDate());
        existing.setSets(updated.getSets());

        return repo.save(existing);
    }

    // GET ALL WORKOUTS
    public List<Workout> getAll() {
        return repo.findAll();
    }

    // VALIDATION LOGIC
    private void validateWorkout(Workout workout) {

        // Built-in exercise validation
        if (workout.getExerciseType() != null) {
            ExerciseType type = workout.getExerciseType();
            if (type.getBodyPart() != workout.getBodyPart()) {
                throw new IllegalArgumentException(
                        "Exercise '" + type + "' does not match body part '" + workout.getBodyPart() + "'"
                );
            }
        }

        // Custom exercise validation
        if (workout.getCustomExercise() != null) {
            CustomExercise ce = workout.getCustomExercise();
            if (ce.getBodyPart() != workout.getBodyPart()) {
                throw new IllegalArgumentException(
                        "Custom exercise '" + ce.getName() +
                                "' does not match body part '" + workout.getBodyPart() + "'"
                );
            }
        }
    }

    public Workout startWorkout(Long id) {

        Workout workout = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Workout not found"));

        workout.setWorkoutStartTime(LocalDateTime.now());

        return repo.save(workout);
    }

    public Workout endWorkout(Long id) {

        Workout workout = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Workout not found"));

        workout.setWorkoutEndTime(LocalDateTime.now());

        // Calculate total duration
        long duration = Duration.between(
                workout.getWorkoutStartTime(),
                workout.getWorkoutEndTime()
        ).getSeconds();

        workout.setTotalDurationSeconds(duration);

        return repo.save(workout);
    }
}