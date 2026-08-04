package com.example.workoutapp.model;

import com.example.workoutapp.model.enums.BodyPart;
import com.example.workoutapp.model.enums.ExerciseType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Built‑in exercise (enum)
    @Enumerated(EnumType.STRING)
    private ExerciseType exerciseType;

    // Custom exercise (DB)
    @ManyToOne
    private CustomExercise customExercise;

    // Body part (enum)
    @Enumerated(EnumType.STRING)
    private BodyPart bodyPart;

    private LocalDate date;

    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL)
    private List<WorkoutSet> sets;

    private LocalDateTime workoutStartTime;
    private LocalDateTime workoutEndTime;
    private Long totalDurationSeconds;
}