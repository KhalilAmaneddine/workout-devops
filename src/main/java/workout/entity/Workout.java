package workout.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.jdbc.Work;
import workout.WorkoutApplication;

@Entity
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer reps;
    private String date;

    public Workout() {
    }

    public Workout(String name, Integer reps, String date) {
        this.name = name;
        this.reps = reps;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getReps() {
        return reps;
    }

    public String getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
