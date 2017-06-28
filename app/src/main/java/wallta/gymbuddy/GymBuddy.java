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

        //mContext = context.getApplicationContext();
        // TODO: initialize new SQLiteOpenHelper in GymBuddy constructor.
    }

    public List<Routine> getRoutines() {
        return mRoutines;
    }

    public Routine getRoutine(UUID routineId) {
        for (Routine routine : mRoutines) {
            if (routine.getRoutineId().equals(routineId)) {
                return routine;
            }
        }
        return  null;
    }

    public List<Day> getDays() {
        return mDays;
    }

    public List<Exercise> getExercises() {
        return mExercises;
    }

}
