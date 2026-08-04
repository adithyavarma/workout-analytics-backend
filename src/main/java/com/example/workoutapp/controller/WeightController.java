package com.example.workoutapp.controller;

import com.example.workoutapp.model.CustomWeight;
import com.example.workoutapp.model.enums.WeightOption;
import com.example.workoutapp.service.WeightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weights")
public class WeightController {

    private final WeightService service;

    public WeightController(WeightService service) {
        this.service = service;
    }

    @GetMapping("/builtin")
    public WeightOption[] getBuiltIn() {
        return WeightOption.values();
    }

    @PostMapping("/custom")
    public CustomWeight addCustom(@RequestParam Double weight) {
        return service.addCustomWeight(weight);
    }

    @GetMapping("/custom")
    public List<CustomWeight> getCustom() {
        return service.getCustomWeights();
    }
}

