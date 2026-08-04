package com.example.workoutapp.service;

import com.example.workoutapp.model.CustomWeight;
import com.example.workoutapp.model.enums.WeightOption;
import com.example.workoutapp.repository.CustomWeightRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class WeightService {

    private final CustomWeightRepository repo;

    public WeightService(CustomWeightRepository repo) {
        this.repo = repo;
    }

    // Built‑in dropdown weights (enum)
    public List<WeightOption> getBuiltInWeights() {
        return Arrays.asList(WeightOption.values());
    }

    // Add custom weight (user-defined)
    public CustomWeight addCustomWeight(Double weight) {
        CustomWeight cw = new CustomWeight();
        cw.setWeight(weight);
        return repo.save(cw);
    }

    // Get all custom weights
    public List<CustomWeight> getCustomWeights() {
        return repo.findAll();
    }

    // Update custom weight
    public CustomWeight updateCustomWeight(Long id, Double newWeight) {
        CustomWeight cw = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Custom weight not found: " + id));

        cw.setWeight(newWeight);
        return repo.save(cw);
    }

    // Delete custom weight
    public void deleteCustomWeight(Long id) {
        repo.deleteById(id);
    }
}
