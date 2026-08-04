package com.example.workoutapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class WorkoutSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double weight;
    private Integer reps;

    // Rest interval provided by UI
    private Long restSeconds;

    @ManyToOne
    private Workout workout;
}