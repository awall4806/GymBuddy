package wallta.gymbuddy;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by wallta on 6/28/2017.
 */

public class GymBuddy {
    private static GymBuddy sGymBuddy;

    private List<Routine> mRoutines;
    private List<Day> mDays;
    private List<Exercise> mExercises;

    //private Context mContext;
    //private SQLiteDatabase mDatabase;

    public static GymBuddy get(Context context) {
        if (sGymBuddy == null) {
            sGymBuddy = new GymBuddy(context);
        }

        return sGymBuddy;
    }

    private GymBuddy(Context context) {
        mRoutines = new ArrayList<>();
        mDays = new ArrayList<>();
        mExercises = new ArrayList<>();

        for (int i = 1; i < 4; i++) {
            Routine routine = new Routine("Routine #" + i);
            mRoutines.add(routine);

            for (int j = 1; j < 5; j++) {
                Day day = new Day(routine.getRoutineId(), "Day #" + i + j);
                mDays.add(day);

                for (int k = 1; k < 6; k++) {
                    Exercise exercise = new Exercise(day.getDayId(), "Exercise #" + i + j + k,
                            5, 5, 45);
                    mExercises.add(exercise);
                }
            }
        }

        //mContext = context.getApplicationContext();
        // TODO: initialize new SQLiteOpenHelper in GymBuddy constructor.
    }

    public List<Routine> getRoutines() {
        return mRoutines;
    }

    public List<Day> getDays() {
        return mDays;
    }

    public List<Exercise> getExercises() {
        return mExercises;
    }

    public Routine getRoutine(UUID routineId) {
        for (Routine routine : mRoutines) {
            if (routine.getRoutineId().equals(routineId)) {
                return routine;
            }
        }
        return  null;
    }

    public Day getDay(UUID dayId) {
        for (Day day : mDays) {
            if (day.getDayId().equals(dayId)) {
                return day;
            }
        }
        return  null;
    }

    public Exercise getExercise(UUID exerciseId) {
        Exercise returnedExercise = null;
        for (Exercise exercise : mExercises) {
            if (exercise.getExerciseId().equals(exerciseId)) {
                returnedExercise = exercise;
                break;
            }
        }
        return returnedExercise;
    }

    public List<Day> getDaysByRoutine(UUID routineId) {
        List<Day> days = new ArrayList<>();
        for (Day day : mDays) {
            if (day.getRoutineId().equals(routineId)) {
                days.add(day);
            }
        }
        return days;
    }

    public List<Exercise> getExercisesByDay(UUID dayId) {
        List<Exercise> exercises = new ArrayList<>();
        for (Exercise exercise : mExercises) {
            if (exercise.getDayId().equals(dayId)) {
                exercises.add(exercise);
            }
        }
        return exercises;
    }
}
