package wallta.gymbuddy;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.UUID;

public class DayListActivity extends AppCompatActivity {

    private static final String EXTRA_DAY_ID = "wallta.gymbuddy.day_id";

    public static Intent newIntent(Context packageContext, UUID dayId) {
        Intent intent = new Intent(packageContext, DayListActivity.class);
        intent.putExtra(EXTRA_DAY_ID, dayId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_list);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.day_list_fragment_container);

        if (fragment == null) {
            fragment = new ExerciseListFragment();

            fm.beginTransaction()
                    .add(R.id.day_list_fragment_container, fragment)
                    .commit();
        }
    }
}
