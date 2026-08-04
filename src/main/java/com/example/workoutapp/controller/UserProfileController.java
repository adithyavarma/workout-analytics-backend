package com.example.workoutapp.controller;

import com.example.workoutapp.model.UserProfile;
import com.example.workoutapp.service.UserProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserProfileController {

    private final UserProfileService service;

    public UserProfileController(UserProfileService service) {
        this.service = service;
    }

    @PostMapping
    public UserProfile save(@RequestBody UserProfile profile) {
        return service.save(profile);
    }

    @GetMapping("/{id}")
    public UserProfile get(@PathVariable Long id) {
        return service.get(id);
    }
}

