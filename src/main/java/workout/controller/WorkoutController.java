package workout.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import workout.entity.Workout;
import workout.repository.WorkoutRepository;

import java.util.List;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {

    private final WorkoutRepository workoutRepository;

    public WorkoutController(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @GetMapping
    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }
    @PostMapping
    public Workout createWorkout(@RequestBody Workout workout) {
        if(workout.getName() == null || workout.getReps() == null)
            throw new RuntimeException("Invalid workout data");
        return workoutRepository.save(workout);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getWorkoutById(@PathVariable Long id) {
        return workoutRepository.findById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body("Workout not found"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWorkout(@PathVariable Long id) {
        if(!workoutRepository.existsById(id))
            return ResponseEntity.status(404).body("Workout not found!");
        workoutRepository.deleteById(id);
        return ResponseEntity.ok( "Workout deleted");
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello Dude, new Text!";
    }
}
