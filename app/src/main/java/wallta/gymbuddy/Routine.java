package wallta.gymbuddy;

import java.util.UUID;

/**
 * Created by awall4806 on 6/26/2017.
 */

public class Routine {

    private UUID mRoutineId;
    private String mName;

    public Routine() {
        mRoutineId = UUID.randomUUID();
    }

    public Routine(String name) {
        mRoutineId = UUID.randomUUID();
        mName = name;
    }

    public UUID getRoutineId() {
        return mRoutineId;
    }

    public void setRoutineId(UUID id) {
        mRoutineId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
