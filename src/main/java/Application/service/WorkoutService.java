package Application.service;

import Application.dao.WorkoutDAO;
import Application.model.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {
    @Autowired
    private WorkoutDAO workoutDAO;

    public boolean saveService(Workout workout) {
        try {
            return workoutDAO.save(workout);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateService(Workout workout, long id, String exerciseName, String muscleName, String recommendedExecutionTime, String description, String numberOfRepetitions, String numberOfApproaches) {
        try {
            workout.setExerciseName(exerciseName);
            workout.setMuscleName(muscleName);
            workout.setRecommendedExecutionTime(recommendedExecutionTime);
            workout.setDescription(description);
            workout.setNumberOfRepetitions(numberOfRepetitions);
            workout.setNumberOfApproaches(numberOfApproaches);
            return workoutDAO.update(workout);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteService(Workout workout) {
        try {
            return workoutDAO.delete(workout);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Workout findId(long id) {
        try {
            return workoutDAO.findId(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Workout> findAll() {
        try {
            return workoutDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Workout> findMuscleNameService(String muscleName) {
        try {
            return workoutDAO.findMuscleName(muscleName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
