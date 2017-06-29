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
    private int mSets;
    private int mRemainingSets;
    private int mSeconds;

    public Exercise() {
        mExerciseId = UUID.randomUUID();
    }

    public Exercise(UUID dayId, String name, int reps, int sets, int seconds) {
        mExerciseId = UUID.randomUUID();
        mDayId = dayId;
        mName = name;
        mCompleted = false;
        mReps = reps;
        mSets = sets;
        mRemainingSets = sets;
        mSeconds = seconds;
    }

    public UUID getDayId() {
        return mDayId;
    }

    public void setDayId(UUID dayId) {
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

    public int getSets() {
        return mSets;
    }

    public void setSets(int sets) {
        mSets = sets;
    }

    public int getRemainingSets() {
        return mRemainingSets;
    }

    public void setRemainingSets(int remainingSets) {
        this.mRemainingSets = remainingSets;
    }

    public int getSeconds() {
        return mSeconds;
    }

    public void setSeconds(int seconds) {
        mSeconds = seconds;
    }
}
