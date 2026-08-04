package com.example.workoutapp.model.enums;

public enum ExerciseType {

    // =========================
    // CHEST
    // =========================
    BENCH_PRESS(BodyPart.CHEST, 6.0),
    INCLINE_BENCH_PRESS(BodyPart.CHEST, 6.0),
    DECLINE_BENCH_PRESS(BodyPart.CHEST, 6.0),
    DUMBBELL_BENCH_PRESS(BodyPart.CHEST, 5.5),
    INCLINE_DUMBBELL_PRESS(BodyPart.CHEST, 5.5),
    CHEST_FLY(BodyPart.CHEST, 4.0),
    DUMBBELL_FLY(BodyPart.CHEST, 4.0),
    CABLE_FLY(BodyPart.CHEST, 4.0),
    PEC_DECK(BodyPart.CHEST, 3.5),
    PUSH_UP(BodyPart.CHEST, 4.0),
    WEIGHTED_PUSH_UP(BodyPart.CHEST, 5.0),
    DIPS(BodyPart.CHEST, 5.0),

    // =========================
    // BACK
    // =========================
    DEADLIFT(BodyPart.BACK, 8.0),
    ROMANIAN_DEADLIFT(BodyPart.BACK, 7.0),
    BARBELL_ROW(BodyPart.BACK, 6.0),
    DUMBBELL_ROW(BodyPart.BACK, 5.0),
    T_BAR_ROW(BodyPart.BACK, 6.0),
    SEATED_CABLE_ROW(BodyPart.BACK, 4.5),
    LAT_PULLDOWN(BodyPart.BACK, 4.5),
    WIDE_GRIP_PULLDOWN(BodyPart.BACK, 5.0),
    CLOSE_GRIP_PULLDOWN(BodyPart.BACK, 4.5),
    PULL_UP(BodyPart.BACK, 7.0),
    CHIN_UP(BodyPart.BACK, 6.0),
    STRAIGHT_ARM_PULLDOWN(BodyPart.BACK, 4.0),
    MACHINE_ROW(BodyPart.BACK, 4.0),
    INVERTED_ROW(BodyPart.BACK, 4.5),

    // =========================
    // SHOULDERS
    // =========================
    SHOULDER_PRESS(BodyPart.SHOULDERS, 5.0),
    DUMBBELL_SHOULDER_PRESS(BodyPart.SHOULDERS, 4.5),
    ARNOLD_PRESS(BodyPart.SHOULDERS, 5.0),
    PUSH_PRESS(BodyPart.SHOULDERS, 6.0),
    LATERAL_RAISE(BodyPart.SHOULDERS, 3.5),
    FRONT_RAISE(BodyPart.SHOULDERS, 3.5),
    REAR_DELT_FLY(BodyPart.SHOULDERS, 3.5),
    CABLE_LATERAL_RAISE(BodyPart.SHOULDERS, 3.5),
    FACE_PULL(BodyPart.SHOULDERS, 3.5),
    UPRIGHT_ROW(BodyPart.SHOULDERS, 4.0),

    // =========================
    // TRAPS
    // =========================
    BARBELL_SHRUG(BodyPart.TRAPS, 4.0),
    DUMBBELL_SHRUG(BodyPart.TRAPS, 3.5),
    MACHINE_SHRUG(BodyPart.TRAPS, 3.5),
    FARMERS_WALK(BodyPart.TRAPS, 8.0),

    // =========================
    // BICEPS
    // =========================
    BARBELL_CURL(BodyPart.BICEPS, 3.5),
    EZ_BAR_CURL(BodyPart.BICEPS, 3.5),
    DUMBBELL_CURL(BodyPart.BICEPS, 3.0),
    HAMMER_CURL(BodyPart.BICEPS, 3.0),
    PREACHER_CURL(BodyPart.BICEPS, 3.0),
    CONCENTRATION_CURL(BodyPart.BICEPS, 3.0),
    CABLE_CURL(BodyPart.BICEPS, 3.0),
    REVERSE_CURL(BodyPart.BICEPS, 3.0),
    SPIDER_CURL(BodyPart.BICEPS, 3.0),

    // =========================
    // TRICEPS
    // =========================
    TRICEP_PULLDOWN(BodyPart.TRICEPS, 3.0),
    ROPE_TRICEP_PULLDOWN(BodyPart.TRICEPS, 3.0),
    OVERHEAD_TRICEP_EXTENSION(BodyPart.TRICEPS, 3.5),
    SKULL_CRUSHER(BodyPart.TRICEPS, 4.0),
    CLOSE_GRIP_BENCH_PRESS(BodyPart.TRICEPS, 5.0),
    TRICEP_KICKBACK(BodyPart.TRICEPS, 3.0),
    BENCH_DIP(BodyPart.TRICEPS, 4.0),
    WEIGHTED_DIP(BodyPart.TRICEPS, 5.0),

    // =========================
    // FOREARMS
    // =========================
    WRIST_CURL(BodyPart.FOREARMS, 2.5),
    REVERSE_WRIST_CURL(BodyPart.FOREARMS, 2.5),
    WRIST_ROLLER(BodyPart.FOREARMS, 3.0),
    PLATE_PINCH(BodyPart.FOREARMS, 2.5),
    FARMERS_HOLD(BodyPart.FOREARMS, 3.0),

    // =========================
    // ABS
    // =========================
    CRUNCH(BodyPart.ABS, 3.0),
    CABLE_CRUNCH(BodyPart.ABS, 3.5),
    DECLINE_CRUNCH(BodyPart.ABS, 3.5),
    LEG_RAISE(BodyPart.ABS, 4.0),
    HANGING_LEG_RAISE(BodyPart.ABS, 4.5),
    V_UP(BodyPart.ABS, 4.0),
    PLANK(BodyPart.ABS, 3.0),
    AB_WHEEL_ROLLOUT(BodyPart.ABS, 4.0),
    MACHINE_CRUNCH(BodyPart.ABS, 3.5),

    // =========================
    // OBLIQUES
    // =========================
    RUSSIAN_TWIST(BodyPart.OBLIQUES, 4.0),
    SIDE_PLANK(BodyPart.OBLIQUES, 3.0),
    WOODCHOP(BodyPart.OBLIQUES, 4.0),
    CABLE_WOODCHOP(BodyPart.OBLIQUES, 4.0),
    BICYCLE_CRUNCH(BodyPart.OBLIQUES, 4.0),
    SIDE_BEND(BodyPart.OBLIQUES, 3.0),

    // =========================
    // LOWER BACK
    // =========================
    BACK_EXTENSION(BodyPart.LOWER_BACK, 4.0),
    GOOD_MORNING(BodyPart.LOWER_BACK, 5.0),
    SUPERMAN(BodyPart.LOWER_BACK, 3.0),
    HYPEREXTENSION(BodyPart.LOWER_BACK, 4.0),

    // =========================
    // GLUTES
    // =========================
    HIP_THRUST(BodyPart.GLUTES, 5.0),
    GLUTE_BRIDGE(BodyPart.GLUTES, 4.0),
    CABLE_KICKBACK(BodyPart.GLUTES, 3.5),
    BULGARIAN_SPLIT_SQUAT(BodyPart.GLUTES, 6.0),
    STEP_UP(BodyPart.GLUTES, 5.0),
    SUMO_DEADLIFT(BodyPart.GLUTES, 8.0),

    // =========================
    // QUADRICEPS
    // =========================
    SQUAT(BodyPart.QUADRICEPS, 7.0),
    FRONT_SQUAT(BodyPart.QUADRICEPS, 7.5),
    GOBLET_SQUAT(BodyPart.QUADRICEPS, 5.0),
    LEG_PRESS(BodyPart.QUADRICEPS, 5.0),
    LEG_EXTENSION(BodyPart.QUADRICEPS, 3.5),
    LUNGE(BodyPart.QUADRICEPS, 5.0),
    WALKING_LUNGE(BodyPart.QUADRICEPS, 5.5),
    HACK_SQUAT(BodyPart.QUADRICEPS, 6.0),

    // =========================
    // HAMSTRINGS
    // =========================
    LEG_CURL(BodyPart.HAMSTRINGS, 3.5),
    LYING_LEG_CURL(BodyPart.HAMSTRINGS, 3.5),
    SEATED_LEG_CURL(BodyPart.HAMSTRINGS, 3.5),
    STIFF_LEG_DEADLIFT(BodyPart.HAMSTRINGS, 6.0),
    ROMANIAN_DEADLIFT_SINGLE_LEG(BodyPart.HAMSTRINGS, 6.0),
    NORDIC_CURL(BodyPart.HAMSTRINGS, 5.0),

    // =========================
    // CALVES
    // =========================
    STANDING_CALF_RAISE(BodyPart.CALVES, 3.5),
    SEATED_CALF_RAISE(BodyPart.CALVES, 3.0),
    DONKEY_CALF_RAISE(BodyPart.CALVES, 3.5),
    SINGLE_LEG_CALF_RAISE(BodyPart.CALVES, 3.5),

    // =========================
    // HIP FLEXORS
    // =========================
    STANDING_KNEE_RAISE(BodyPart.HIP_FLEXORS, 3.0),
    HANGING_KNEE_RAISE(BodyPart.HIP_FLEXORS, 3.5),
    RESISTANCE_BAND_HIP_FLEXION(BodyPart.HIP_FLEXORS, 3.0),

    // =========================
    // ADDUCTORS
    // =========================
    HIP_ADDUCTION_MACHINE(BodyPart.ADDUCTORS, 3.0),
    CABLE_HIP_ADDUCTION(BodyPart.ADDUCTORS, 3.0),
    COPENHAGEN_PLANK(BodyPart.ADDUCTORS, 3.5),

    // =========================
    // ABDUCTORS
    // =========================
    HIP_ABDUCTION_MACHINE(BodyPart.ABDUCTORS, 3.0),
    CABLE_HIP_ABDUCTION(BodyPart.ABDUCTORS, 3.0),
    BANDED_SIDE_WALK(BodyPart.ABDUCTORS, 3.0),
    CLAMSHELL(BodyPart.ABDUCTORS, 3.0),

    // =========================
    // FULL BODY
    // =========================
    BURPEE(BodyPart.FULL_BODY, 8.0),
    THRUSTER(BodyPart.FULL_BODY, 7.0),
    CLEAN_AND_PRESS(BodyPart.FULL_BODY, 8.0),
    CLEAN_AND_JERK(BodyPart.FULL_BODY, 8.5),
    SNATCH(BodyPart.FULL_BODY, 9.0),
    KETTLEBELL_SWING(BodyPart.FULL_BODY, 7.0),
    MEDICINE_BALL_SLAM(BodyPart.FULL_BODY, 6.0),
    BOX_JUMP(BodyPart.FULL_BODY, 7.0),
    SLED_PUSH(BodyPart.FULL_BODY, 8.0),
    SLED_PULL(BodyPart.FULL_BODY, 8.0),
    BATTLE_ROPES(BodyPart.FULL_BODY, 7.0),

    // =========================
    // CARDIO
    // =========================
    RUNNING(BodyPart.CARDIO, 9.0),
    TREADMILL(BodyPart.CARDIO, 8.0),
    WALKING(BodyPart.CARDIO, 3.5),
    CYCLING(BodyPart.CARDIO, 7.5),
    STATIONARY_BIKE(BodyPart.CARDIO, 7.0),
    ROWING(BodyPart.CARDIO, 8.0),
    ELLIPTICAL(BodyPart.CARDIO, 5.0),
    STAIR_CLIMBER(BodyPart.CARDIO, 7.0),
    JUMP_ROPE(BodyPart.CARDIO, 10.0),
    SWIMMING(BodyPart.CARDIO, 8.0),
    HIIT(BodyPart.CARDIO, 12.0);

    private final BodyPart bodyPart;
    private final double met;

    ExerciseType(BodyPart bodyPart, double met){
        this.bodyPart = bodyPart;
        this.met = met;
    }

    public BodyPart getBodyPart(){
        return bodyPart;
    }

    public double getMet() {
        return met;
    }
}