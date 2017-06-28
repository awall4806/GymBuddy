package wallta.gymbuddy;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.UUID;

public class ExerciseListActivity extends AppCompatActivity {

    private static final String EXTRA_EXERCISE_ID = "wallta.gymbuddy.exercise_id";

    public static Intent newIntent(Context packageContext, UUID exerciseId) {
        Intent intent = new Intent(packageContext, DayListActivity.class);
        intent.putExtra(EXTRA_EXERCISE_ID, exerciseId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.exercise_list_fragment_container);

        if (fragment == null) {
            fragment = new ExerciseListFragment();

            fm.beginTransaction()
                    .add(R.id.exercise_list_fragment_container, fragment)
                    .commit();
        }
    }
}
