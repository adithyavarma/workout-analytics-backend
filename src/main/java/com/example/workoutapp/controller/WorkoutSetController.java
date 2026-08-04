package com.example.workoutapp.controller;

import com.example.workoutapp.model.WorkoutSet;
import com.example.workoutapp.service.WorkoutSetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workouts/{workoutId}/sets")
public class WorkoutSetController {

    private final WorkoutSetService service;

    public WorkoutSetController(WorkoutSetService service) {
        this.service = service;
    }

    // ADD SET WITH REST INTERVAL
    @PostMapping
    public WorkoutSet addSet(
            @PathVariable Long workoutId,
            @RequestBody WorkoutSet set
    ) {
        return service.addSet(workoutId, set);
    }

    // UPDATE SET
    @PutMapping("/{setId}")
    public WorkoutSet updateSet(
            @PathVariable Long workoutId,
            @PathVariable Long setId,
            @RequestBody WorkoutSet set
    ) {
        return service.updateSet(setId, set);
    }

    // DELETE SET
    @DeleteMapping("/{setId}")
    public void deleteSet(
            @PathVariable Long workoutId,
            @PathVariable Long setId
    ) {
        service.deleteSet(setId);
    }

    // GET ALL SETS FOR WORKOUT
    @GetMapping
    public List<WorkoutSet> getSets(@PathVariable Long workoutId) {
        return service.getSetsForWorkout(workoutId);
    }
}