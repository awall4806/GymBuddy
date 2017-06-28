package wallta.gymbuddy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by wallta on 6/28/2017.
 */

public class ExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.exercise_fragment_container);

        if (fragment == null) {
            fragment = new ExerciseListFragment();

            fm.beginTransaction()
                    .add(R.id.exercise_fragment_container, fragment)
                    .commit();
        }
    }
}
