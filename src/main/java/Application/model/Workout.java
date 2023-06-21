package Application.model;

import javax.persistence.*;

@Entity
@Table(name = "t_workout")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "exerciseName", unique = true)
    private String exerciseName;

    @Column(name = "muscleName")
    private String muscleName;

    @Column(name = "recommendedExecutionTime")
    private String recommendedExecutionTime;

    @Column(name = "description")
    private String description;

    @Column(name = "numberOfRepetitions")
    private String numberOfRepetitions;

    @Column(name = "numberOfApproaches")
    private String numberOfApproaches;

    public Workout() {

    }

    public Workout(String exerciseName, String muscleName, String recommendedExecutionTime, String description,
                   String numberOfRepetitions, String numberOfApproaches) {
        this.exerciseName = exerciseName;
        this.muscleName = muscleName;
        this.recommendedExecutionTime = recommendedExecutionTime;
        this.description = description;
        this.numberOfRepetitions = numberOfRepetitions;
        this.numberOfApproaches = numberOfApproaches;
    }

    public long getId() {
        return id;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getMuscleName() {
        return muscleName;
    }

    public void setMuscleName(String muscleName) {
        this.muscleName = muscleName;
    }

    public String getRecommendedExecutionTime() {
        return recommendedExecutionTime;
    }

    public void setRecommendedExecutionTime(String recommendedExecutionTime) {
        this.recommendedExecutionTime = recommendedExecutionTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumberOfRepetitions() {
        return numberOfRepetitions;
    }

    public void setNumberOfRepetitions(String numberOfRepetitions) {
        this.numberOfRepetitions = numberOfRepetitions;
    }

    public String getNumberOfApproaches() {
        return numberOfApproaches;
    }

    public void setNumberOfApproaches(String numberOfApproaches) {
        this.numberOfApproaches = numberOfApproaches;
    }
}
