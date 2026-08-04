package com.example.workoutapp.controller;

import com.example.workoutapp.model.CustomBodyPart;
import com.example.workoutapp.model.enums.BodyPart;
import com.example.workoutapp.service.BodyPartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bodyparts")
public class BodyPartController {

    private final BodyPartService service;

    public BodyPartController(BodyPartService service) {
        this.service = service;
    }

    @GetMapping("/builtin")
    public BodyPart[] getBuiltIn() {
        return BodyPart.values();
    }

    @PostMapping("/custom")
    public CustomBodyPart addCustom(@RequestParam String name) {
        return service.addCustom(name);
    }

    @GetMapping("/custom")
    public List<CustomBodyPart> getCustom() {
        return service.getCustom();
    }
}

