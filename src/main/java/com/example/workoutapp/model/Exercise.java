package com.example.workoutapp.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category; // Chest, Back, Legs, Shoulders, Arms, Core
}