package wallta.gymbuddy;

import java.util.UUID;

/**
 * Created by awall4806 on 6/26/2017.
 */

public class Exercise {

    private UUID mId;
    private String mName;
    private int mReps;
    private int mSeconds;

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
