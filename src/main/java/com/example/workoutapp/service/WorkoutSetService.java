package com.example.workoutapp.service;

import com.example.workoutapp.model.Workout;
import com.example.workoutapp.model.WorkoutSet;
import com.example.workoutapp.repository.WorkoutRepository;
import com.example.workoutapp.repository.WorkoutSetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutSetService {

    private final WorkoutSetRepository setRepo;
    private final WorkoutRepository workoutRepo;

    public WorkoutSetService(WorkoutSetRepository setRepo, WorkoutRepository workoutRepo) {
        this.setRepo = setRepo;
        this.workoutRepo = workoutRepo;
    }

    // ADD SET WITH REST INTERVAL FROM UI
    public WorkoutSet addSet(Long workoutId, WorkoutSet newSet) {

        Workout workout = workoutRepo.findById(workoutId)
                .orElseThrow(() -> new RuntimeException("Workout not found"));

        newSet.setWorkout(workout);

        return setRepo.save(newSet);
    }

    // UPDATE SET
    public WorkoutSet updateSet(Long setId, WorkoutSet updated) {

        WorkoutSet existing = setRepo.findById(setId)
                .orElseThrow(() -> new RuntimeException("Set not found"));

        existing.setWeight(updated.getWeight());
        existing.setReps(updated.getReps());
        existing.setRestSeconds(updated.getRestSeconds());

        return setRepo.save(existing);
    }

    // DELETE SET
    public void deleteSet(Long setId) {
        setRepo.deleteById(setId);
    }

    // GET ALL SETS FOR A WORKOUT
    public List<WorkoutSet> getSetsForWorkout(Long workoutId) {
        Workout workout = workoutRepo.findById(workoutId)
                .orElseThrow(() -> new RuntimeException("Workout not found"));

        return workout.getSets();
    }

    public double calculateIntensity(WorkoutSet set) {

        double volume = set.getWeight() * set.getReps();

        double restFactor = (set.getRestSeconds() <= 60) ? 1.2 :
                (set.getRestSeconds() <= 120) ? 1.0 : 0.8;

        return volume * restFactor;
    }
}