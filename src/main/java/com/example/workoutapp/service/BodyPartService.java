package com.example.workoutapp.service;

import com.example.workoutapp.model.CustomBodyPart;
import com.example.workoutapp.repository.CustomBodyPartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BodyPartService {

    private final CustomBodyPartRepository repo;

    public BodyPartService(CustomBodyPartRepository repo) {
        this.repo = repo;
    }

    public CustomBodyPart addCustom(String name) {
        CustomBodyPart bp = new CustomBodyPart();
        bp.setName(name);
        return repo.save(bp);
    }

    public List<CustomBodyPart> getCustom() {
        return repo.findAll();
    }
}

