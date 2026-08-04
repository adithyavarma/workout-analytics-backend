package com.example.workoutapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CustomBodyPart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}