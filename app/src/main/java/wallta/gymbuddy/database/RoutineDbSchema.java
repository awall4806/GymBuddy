package wallta.gymbuddy.database;

import java.util.ArrayList;

/**
 * Created by awall4806 on 6/26/2017.
 */

public class RoutineDbSchema {
    public static final class RoutineTable {
        public static final String ROUTINE_NAME = "routine";
        public static final ArrayList<DayTable> days = new ArrayList<>();

        public static final class DayTable {
            public static final String DAY_OF_WEEK = "day";
            public static final ArrayList<ExerciseTable> exercises =
                    new ArrayList<>();
            //public static final String MUSCLE_GROUP = "muscle group";
            //public static final String EXERCISE_TYPE = "exercise type";

            public static final class ExerciseTable {
                public static final String EXERCISE_NAME = "exercise";
                public static final String  REPS = "reps";
                public static final String REST_TIMER_SECONDS = "seconds";
            }
        }
    }
}
