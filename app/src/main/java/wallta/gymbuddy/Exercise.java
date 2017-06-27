package wallta.gymbuddy;

import java.util.UUID;

/**
 * Created by awall4806 on 6/26/2017.
 */

public class Exercise {

    private UUID mId;
    private String mName;
    private boolean mCompleted;
    private int mReps;
    private int mSeconds;

    public Exercise() {
        mId = UUID.randomUUID();
    }

    public Exercise(String name, boolean completed, int reps, int seconds) {
        mId = UUID.randomUUID();
        mName = name;
        mCompleted = completed;
        mReps = reps;
        mSeconds = seconds;
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
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

    public int getSeconds() {
        return mSeconds;
    }

    public void setSeconds(int seconds) {
        mSeconds = seconds;
    }
}
