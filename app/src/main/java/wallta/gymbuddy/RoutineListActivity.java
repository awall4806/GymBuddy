package wallta.gymbuddy;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.UUID;

public class RoutineListActivity extends AppCompatActivity {

    private static final String EXTRA_ROUTINE_ID = "wallta.gymbuddy.routine_id";

    public static Intent newIntent(Context packageContext, UUID routineId) {
        Intent intent = new Intent(packageContext, DayListActivity.class);
        intent.putExtra(EXTRA_ROUTINE_ID, routineId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine_list);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.routine_list_fragment_container);

        if (fragment == null) {
            fragment = new RoutineListFragment();

            fm.beginTransaction()
                    .add(R.id.routine_list_fragment_container, fragment)
                    .commit();
        }
    }
}
