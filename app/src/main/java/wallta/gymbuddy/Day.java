package wallta.gymbuddy;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by awall4806 on 6/26/2017.
 */

public class Day {

    private UUID mId;
    private String mDay;
    private ArrayList<Exercise> mExercises;
    //private String mMuscleGroup;
    //private String mExerciseType;

    public Day() {
        mId = UUID.randomUUID();
    }

    public Day(String day, ArrayList<Exercise> exercises) {
        mId = UUID.randomUUID();
        mDay = day;
        mExercises = new ArrayList<>();
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public String getDay() {
        return mDay;
    }

    public void setDay(String day) {
        mDay = day;
    }

    public ArrayList<Exercise> getExercises() {
        return mExercises;
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        mExercises = exercises;
    }

    public Exercise getExercise(UUID id) {
        for (Exercise exercise : mExercises) {
            if (exercise.getId() == id) {
                return exercise;
            }
        }
        return null;
    }
}
