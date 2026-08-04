package com.example.workoutapp.controller;

import com.example.workoutapp.model.Workout;
import com.example.workoutapp.service.WorkoutService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

    private final WorkoutService service;

    public WorkoutController(WorkoutService service) {
        this.service = service;
    }

    @PostMapping
    public Workout create(@RequestBody Workout w) {
        return service.createWorkout(w);
    }

    @PutMapping("/{id}")
    public Workout update(@PathVariable Long id, @RequestBody Workout workout) {
        return service.updateWorkout(id, workout);
    }

    @GetMapping
    public List<Workout> getAll() {
        return service.getAll();
    }

    @PostMapping("/{id}/start")
    public Workout start(@PathVariable Long id) {
        return service.startWorkout(id);
    }

    @PostMapping("/{id}/end")
    public Workout end(@PathVariable Long id) {
        return service.endWorkout(id);
    }
}