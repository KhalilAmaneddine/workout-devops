package workout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import workout.entity.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {

}
