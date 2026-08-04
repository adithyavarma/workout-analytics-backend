package com.example.workoutapp.service;

import com.example.workoutapp.model.UserProfile;
import com.example.workoutapp.repository.UserProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    private final UserProfileRepository repo;

    public UserProfileService(UserProfileRepository repo) {
        this.repo = repo;
    }

    public UserProfile save(UserProfile profile) {
        return repo.save(profile);
    }

    public UserProfile get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}

