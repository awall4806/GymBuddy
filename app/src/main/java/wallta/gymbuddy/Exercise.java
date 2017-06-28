package wallta.gymbuddy;

import java.util.UUID;

/**
 * Created by awall4806 on 6/26/2017.
 */

public class Exercise {

    private UUID mDayId;
    private UUID mExerciseId;
    private String mName;
    private boolean mCompleted;
    private int mReps;
    private int mRemainingReps;
    private int mSeconds;

    public Exercise() {
        mExerciseId = UUID.randomUUID();
    }

    public Exercise(UUID dayId, String name, boolean completed, int reps, int seconds) {
        mExerciseId = UUID.randomUUID();
        mDayId = dayId;
        mName = name;
        mCompleted = completed;
        mReps = reps;
        mSeconds = seconds;
    }

    public UUID getDayId() {
        return mDayId;
    }

    public void setmDayId(UUID dayId) {
        mDayId = dayId;
    }

    public UUID getExerciseId() {
        return mExerciseId;
    }

    public void setExerciseId(UUID id) {
        mExerciseId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public boolean isCompleted() {
        return mCompleted;
    }

    public void setCompleted(boolean completed) {
        mCompleted = completed;
    }

    public int getReps() {
        return mReps;
    }

    public void setReps(int reps) {
        mReps = reps;
    }

    public int getRemainingReps() {
        return mRemainingReps;
    }

    public void setRemainingReps(int remainingReps) {
        this.mRemainingReps = remainingReps;
    }

    public int getSeconds() {
        return mSeconds;
    }

    public void setSeconds(int seconds) {
        mSeconds = seconds;
    }
}
