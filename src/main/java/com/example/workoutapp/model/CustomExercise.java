package com.example.workoutapp.model;

import com.example.workoutapp.model.enums.BodyPart;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CustomExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private BodyPart bodyPart; // user chooses from enum or custom
}
