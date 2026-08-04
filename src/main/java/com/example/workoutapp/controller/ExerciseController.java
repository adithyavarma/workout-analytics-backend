package com.example.workoutapp.controller;

import com.example.workoutapp.model.CustomExercise;
import com.example.workoutapp.model.Exercise;
import com.example.workoutapp.model.enums.BodyPart;
import com.example.workoutapp.model.enums.ExerciseType;
import com.example.workoutapp.service.ExerciseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {

    private final ExerciseService service;

    public ExerciseController(ExerciseService service) {
        this.service = service;
    }

//    @GetMapping("/builtin")
//    public ExerciseType[] getBuiltIn() {
//        return ExerciseType.values();
//    }

    @GetMapping("/builtin/{bodyPart}")
    public List<ExerciseType> getBuiltInByBodyPart(@PathVariable BodyPart bodyPart) {
        return service.getBuiltInByBodyPart(bodyPart);
    }

    @PostMapping("/custom")
    public CustomExercise addCustom(@RequestBody CustomExercise e) {
        return service.addCustom(e);
    }

//    @GetMapping("/custom")
//    public List<CustomExercise> getCustom() {
//        return service.getCustom();
//    }

    @GetMapping("/custom/{bodyPart}")
    public List<CustomExercise> getCustomByBodyPart(@PathVariable BodyPart bodyPart) {
        return service.getCustomByBodyPart(bodyPart);
    }
}
