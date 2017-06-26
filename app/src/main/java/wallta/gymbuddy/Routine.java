package wallta.gymbuddy;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by awall4806 on 6/26/2017.
 */

public class Routine {

    private UUID mId;
    private String mName;
    private ArrayList<Day> mDays = new ArrayList<>();

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

    public ArrayList<Day> getDays() {
        return mDays;
    }

    public void setDays(ArrayList<Day> days) {
        mDays = days;
    }

    public Day getDay(UUID id) {
        for (Day day : mDays) {
            if (day.getId() == id) {
                return day;
            }
        }
        return null;
    }
}
