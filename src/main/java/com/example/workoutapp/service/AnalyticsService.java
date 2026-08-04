package com.example.workoutapp.service;

import com.example.workoutapp.dto.*;
import com.example.workoutapp.model.UserProfile;
import com.example.workoutapp.model.Workout;
import com.example.workoutapp.model.WorkoutSet;
import com.example.workoutapp.model.enums.BodyPart;
import com.example.workoutapp.repository.UserProfileRepository;
import com.example.workoutapp.repository.WorkoutRepository;
import com.example.workoutapp.repository.WorkoutSetRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AnalyticsService {

    private final WorkoutRepository workoutRepo;
    private final WorkoutSetRepository setRepo;
    private final CalorieService calorieService;
    private final UserProfileRepository userRepo;

    public AnalyticsService(WorkoutRepository workoutRepo, WorkoutSetRepository setRepo, CalorieService calorieService, UserProfileRepository userRepo) {
        this.workoutRepo = workoutRepo;
        this.setRepo = setRepo;
        this.calorieService = calorieService;
        this.userRepo = userRepo;
    }

    public List<Workout> getWeeklyWorkouts(LocalDate weekStart) {
        LocalDate weekEnd = weekStart.plusDays(7);
        return workoutRepo.findByDateBetween(weekStart, weekEnd);
    }

    public List<Workout> getMonthlyWorkouts(int year, int month) {
        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end = start.plusMonths(1);
        return workoutRepo.findByDateBetween(start, end);
    }

    public double getTotalVolumeForWorkout(Long workoutId) {
        return setRepo.findByWorkoutId(workoutId)
                .stream()
                .mapToDouble(s -> s.getWeight() * s.getReps())
                .sum();
    }

    public double getAverageRestForWorkout(Long workoutId) {
        return setRepo.findByWorkoutId(workoutId)
                .stream()
                .mapToLong(WorkoutSet::getRestSeconds)
                .average()
                .orElse(0);
    }

    public double getDailyCalories(LocalDate date, double weightKg) {

        List<Workout> workouts = workoutRepo.findByDate(date);

        return workouts.stream()
                .mapToDouble(w -> calorieService.calculateCaloriesForWorkout(w, weightKg))
                .sum();
    }


    public double getMonthlyCalories(int year, int month, double weightKg) {

        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end = start.plusMonths(1);

        List<Workout> workouts = workoutRepo.findByDateBetween(start, end);

        return workouts.stream()
                .mapToDouble(w -> calorieService.calculateCaloriesForWorkout(w, weightKg))
                .sum();
    }

    public WorkoutSummaryDTO getWorkoutSummary(Long workoutId, double weightKg) {

        Workout workout = workoutRepo.findById(workoutId)
                .orElseThrow(() -> new RuntimeException("Workout not found"));

        List<WorkoutSet> sets = setRepo.findByWorkoutId(workoutId);

        double totalVolume = sets.stream()
                .mapToDouble(s -> s.getWeight() * s.getReps())
                .sum();

        double avgRest = sets.stream()
                .mapToLong(WorkoutSet::getRestSeconds)
                .average()
                .orElse(0);

        double intensity = sets.stream()
                .mapToDouble(this::calculateIntensity)
                .sum();

        double calories = calorieService.calculateCaloriesForWorkout(workout, weightKg);

        WorkoutSummaryDTO dto = new WorkoutSummaryDTO();
        dto.setWorkoutId(workoutId);
        dto.setExerciseName(workout.getExerciseType().name());
        dto.setBodyPart(workout.getBodyPart());
        dto.setDurationSeconds(workout.getTotalDurationSeconds());
        dto.setTotalVolume(totalVolume);
        dto.setAverageRestSeconds(avgRest);
        dto.setIntensityScore(intensity);
        dto.setCaloriesBurned(calories);

        return dto;
    }
    public double calculateIntensity(WorkoutSet set) {

        double volume = set.getWeight() * set.getReps();

        double restFactor = (set.getRestSeconds() <= 60) ? 1.2 :
                (set.getRestSeconds() <= 120) ? 1.0 : 0.8;

        return volume * restFactor;
    }

    public WeeklyCalorieTrendDTO getWeeklyCalorieTrend(LocalDate startDate, double weightKg) {

        LocalDate endDate = startDate.plusDays(6);

        Map<LocalDate, Double> dailyMap = new LinkedHashMap<>();

        double total = 0;

        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {

            List<Workout> workouts = workoutRepo.findByDate(date);

            double dailyCalories = workouts.stream()
                    .mapToDouble(w -> calorieService.calculateCaloriesForWorkout(w, weightKg))
                    .sum();

            dailyMap.put(date, dailyCalories);
            total += dailyCalories;
        }

        WeeklyCalorieTrendDTO dto = new WeeklyCalorieTrendDTO();
        dto.setWeekStart(startDate);
        dto.setWeekEnd(endDate);
        dto.setDailyCalories(dailyMap);
        dto.setTotalWeeklyCalories(total);
        dto.setAverageDailyCalories(total / 7.0);

        return dto;
    }

    public MonthlyProgressDTO getMonthlyProgress(int year, int month, double weightKg) {

        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end = start.plusMonths(1);

        List<Workout> workouts = workoutRepo.findByDateBetween(start, end);

        double totalCalories = workouts.stream()
                .mapToDouble(w -> calorieService.calculateCaloriesForWorkout(w, weightKg))
                .sum();

        double totalVolume = workouts.stream()
                .flatMap(w -> setRepo.findByWorkoutId(w.getId()).stream())
                .mapToDouble(s -> s.getWeight() * s.getReps())
                .sum();

        double avgRest = workouts.stream()
                .flatMap(w -> setRepo.findByWorkoutId(w.getId()).stream())
                .mapToLong(WorkoutSet::getRestSeconds)
                .average()
                .orElse(0);

        int totalSets = workouts.stream()
                .mapToInt(w -> setRepo.findByWorkoutId(w.getId()).size())
                .sum();

        Map<BodyPart, Long> bodyPartCount = workouts.stream()
                .collect(Collectors.groupingBy(Workout::getBodyPart, Collectors.counting()));

        BodyPart mostTrained = bodyPartCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        MonthlyProgressDTO dto = new MonthlyProgressDTO();
        dto.setYear(year);
        dto.setMonth(month);
        dto.setTotalCalories(totalCalories);
        dto.setAverageCaloriesPerDay(totalCalories / start.lengthOfMonth());
        dto.setTotalVolume(totalVolume);
        dto.setAverageRest(avgRest);
        dto.setTotalWorkouts(workouts.size());
        dto.setTotalSets(totalSets);
        dto.setMostTrainedBodyPart(mostTrained);

        return dto;
    }

    public DashboardDTO getDashboard(Long userId) {

        UserProfile user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        double weight = user.getWeightKg();

        LocalDate today = LocalDate.now();
        LocalDate weekStart = today.minusDays(6);
        int year = today.getYear();
        int month = today.getMonthValue();

        DashboardDTO dto = new DashboardDTO();

        dto.setTodayCalories(getDailyCalories(today, weight));
        dto.setWeeklyCalories(getWeeklyCalorieTrend(weekStart, weight).getTotalWeeklyCalories());
        dto.setMonthlyCalories(getMonthlyCalories(year, month, weight));

        // last workout summary
        Workout lastWorkout = workoutRepo.findAll().stream()
                .max(Comparator.comparing(Workout::getDate))
                .orElse(null);

        if (lastWorkout != null) {
            dto.setLastWorkoutSummary(getWorkoutSummary(lastWorkout.getId(), weight));
        }

        return dto;
    }

    public List<ExerciseCaloriesDTO> getTopExercisesByCalories(double weightKg) {

        List<Workout> workouts = workoutRepo.findAll();

        Map<String, Double> map = new HashMap<>();

        for (Workout w : workouts) {
            double calories = calorieService.calculateCaloriesForWorkout(w, weightKg);
            map.merge(w.getExerciseType().name(), calories, Double::sum);
        }

        return map.entrySet().stream()
                .map(e -> {
                    ExerciseCaloriesDTO dto = new ExerciseCaloriesDTO();
                    dto.setExerciseName(e.getKey());
                    dto.setCaloriesBurned(e.getValue());
                    return dto;
                })
                .sorted(Comparator.comparing(ExerciseCaloriesDTO::getCaloriesBurned).reversed())
                .collect(Collectors.toList());
    }

    public List<BodyPartCaloriesDTO> getBodyPartCalories(double weightKg) {

        List<Workout> workouts = workoutRepo.findAll();

        Map<BodyPart, Double> map = new HashMap<>();

        for (Workout w : workouts) {
            double calories = calorieService.calculateCaloriesForWorkout(w, weightKg);
            map.merge(w.getBodyPart(), calories, Double::sum);
        }

        return map.entrySet().stream()
                .map(e -> {
                    BodyPartCaloriesDTO dto = new BodyPartCaloriesDTO();
                    dto.setBodyPart(e.getKey());
                    dto.setCaloriesBurned(e.getValue());
                    return dto;
                })
                .sorted(Comparator.comparing(BodyPartCaloriesDTO::getCaloriesBurned).reversed())
                .collect(Collectors.toList());
    }


}
