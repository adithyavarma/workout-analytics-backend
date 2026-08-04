package com.example.workoutapp.controller;

import com.example.workoutapp.dto.*;
import com.example.workoutapp.model.UserProfile;
import com.example.workoutapp.model.Workout;
import com.example.workoutapp.model.WorkoutSet;
import com.example.workoutapp.repository.UserProfileRepository;
import com.example.workoutapp.repository.WorkoutRepository;
import com.example.workoutapp.repository.WorkoutSetRepository;
import com.example.workoutapp.service.AnalyticsService;
import com.example.workoutapp.service.CalorieService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    private final AnalyticsService analyticsService;
    private final WorkoutRepository workoutRepo;
    private final WorkoutSetRepository setRepo;
    private final UserProfileRepository userRepo;
    private final CalorieService calorieService;

    public AnalyticsController(
            AnalyticsService analyticsService,
            WorkoutRepository workoutRepo,
            WorkoutSetRepository setRepo,
            UserProfileRepository userRepo,
            CalorieService calorieService
    ) {
        this.analyticsService = analyticsService;
        this.workoutRepo = workoutRepo;
        this.setRepo = setRepo;
        this.userRepo = userRepo;
        this.calorieService = calorieService;
    }

    // ============================
    // EXISTING ENDPOINTS
    // ============================

    @GetMapping("/weekly")
    public List<Workout> weekly(@RequestParam String startDate) {
        return analyticsService.getWeeklyWorkouts(LocalDate.parse(startDate));
    }

    @GetMapping("/monthly")
    public List<Workout> monthly(@RequestParam int year, @RequestParam int month) {
        return analyticsService.getMonthlyWorkouts(year, month);
    }

    @GetMapping("/{workoutId}/volume")
    public double volume(@PathVariable Long workoutId) {
        return analyticsService.getTotalVolumeForWorkout(workoutId);
    }

    @GetMapping("/{workoutId}/rest-average")
    public double restAvg(@PathVariable Long workoutId) {
        return analyticsService.getAverageRestForWorkout(workoutId);
    }

    // ============================
    // NEW ENDPOINTS
    // ============================

    // ⭐ Calories per workout
    @GetMapping("/{workoutId}/calories")
    public double caloriesPerWorkout(@PathVariable Long workoutId, @RequestParam Long userId) {

        Workout workout = workoutRepo.findById(workoutId)
                .orElseThrow(() -> new RuntimeException("Workout not found"));

        UserProfile user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return calorieService.calculateCaloriesForWorkout(workout, user.getWeightKg());
    }

    // ⭐ Calories per set
    @GetMapping("/sets/{setId}/calories")
    public double caloriesPerSet(@PathVariable Long setId, @RequestParam Long userId) {

        WorkoutSet set = setRepo.findById(setId)
                .orElseThrow(() -> new RuntimeException("Set not found"));

        UserProfile user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        double met = set.getWorkout().getExerciseType().getMet();

        return calorieService.calculateCaloriesForSet(set, user.getWeightKg(), met);
    }

    // ⭐ Daily calorie summary
    @GetMapping("/daily")
    public double dailyCalories(@RequestParam String date, @RequestParam Long userId) {

        UserProfile user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return analyticsService.getDailyCalories(LocalDate.parse(date), user.getWeightKg());
    }

    // ⭐ Monthly calorie summary
    @GetMapping("/monthly-calories")
    public double monthlyCalories(@RequestParam int year, @RequestParam int month, @RequestParam Long userId) {

        UserProfile user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return analyticsService.getMonthlyCalories(year, month, user.getWeightKg());
    }

    // ⭐ Full workout summary
    @GetMapping("/{workoutId}/summary")
    public WorkoutSummaryDTO summary(@PathVariable Long workoutId, @RequestParam Long userId) {

        UserProfile user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return analyticsService.getWorkoutSummary(workoutId, user.getWeightKg());
    }

    @GetMapping("/weekly-calories")
    public WeeklyCalorieTrendDTO weeklyCalories(
            @RequestParam String startDate,
            @RequestParam Long userId
    ) {
        UserProfile user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return analyticsService.getWeeklyCalorieTrend(LocalDate.parse(startDate), user.getWeightKg());
    }


    @GetMapping("/monthly-progress")
    public MonthlyProgressDTO monthlyProgress(
            @RequestParam int year,
            @RequestParam int month,
            @RequestParam Long userId
    ) {
        UserProfile user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return analyticsService.getMonthlyProgress(year, month, user.getWeightKg());
    }

    @GetMapping("/dashboard")
    public DashboardDTO dashboard(@RequestParam Long userId) {
        return analyticsService.getDashboard(userId);
    }

    @GetMapping("/top-exercises")
    public List<ExerciseCaloriesDTO> topExercises(@RequestParam Long userId) {

        UserProfile user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return analyticsService.getTopExercisesByCalories(user.getWeightKg());
    }

    @GetMapping("/bodypart-calories")
    public List<BodyPartCaloriesDTO> bodyPartCalories(@RequestParam Long userId) {

        UserProfile user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return analyticsService.getBodyPartCalories(user.getWeightKg());
    }

}
