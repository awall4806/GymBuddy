package wallta.gymbuddy;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class DayListActivity extends SingleFragmentActivity {

    public static final String EXTRA_ROUTINE_ID = "wallta.gymbuddy.routine_id";

    public static Intent newIntent(Context packageContext, UUID routineId) {
        Intent intent = new Intent(packageContext, DayListActivity.class);
        intent.putExtra(EXTRA_ROUTINE_ID, routineId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return new DayListFragment();
    }


}
