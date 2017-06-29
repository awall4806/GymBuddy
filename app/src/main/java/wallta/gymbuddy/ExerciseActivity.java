package wallta.gymbuddy;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * Created by wallta on 6/28/2017.
 */

public class ExerciseActivity extends SingleFragmentActivity {

    private static final String EXTRA_EXERCISE_ID = "wallta.gymbuddy.exercise_id";

    public static Intent newIntent(Context packageContext, UUID exerciseId) {
        Intent intent = new Intent(packageContext, ExerciseActivity.class);
        intent.putExtra(EXTRA_EXERCISE_ID, exerciseId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        UUID exerciseId = (UUID) getIntent().getSerializableExtra(EXTRA_EXERCISE_ID);
        return ExerciseFragment.newInstance(exerciseId);
    }
}
