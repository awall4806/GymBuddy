package wallta.gymbuddy;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class ExerciseListActivity extends SingleFragmentActivity {

    private static final String EXTRA_EXERCISE_ID = "wallta.gymbuddy.exercise_id";

    public static Intent newIntent(Context packageContext, UUID exerciseId) {
        Intent intent = new Intent(packageContext, DayListActivity.class);
        intent.putExtra(EXTRA_EXERCISE_ID, exerciseId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return new ExerciseListFragment();
    }
}
