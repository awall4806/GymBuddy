package wallta.gymbuddy;

import java.util.UUID;

/**
 * Created by awall4806 on 6/26/2017.
 */

public class Day {
    private UUID mRoutineId;
    private UUID mDayId;
    private String mDay;
    //private String mMuscleGroup;
    //private String mExerciseType;

    public Day() {
        mDayId = UUID.randomUUID();
    }

    public Day(UUID routine, String day) {
        mDayId = UUID.randomUUID();
        mRoutineId = routine;
        mDay = day;
    }

    public UUID getRoutineId() {
        return mRoutineId;
    }

    public void setRoutineId(UUID routineId) {
        mRoutineId = routineId;
    }

    public UUID getDayId() {
        return mDayId;
    }

    public void setDayId(UUID id) {
        mDayId = id;
    }

    public String getDay() {
        return mDay;
    }

    public void setDay(String day) {
        mDay = day;
    }
}
