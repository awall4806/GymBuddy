package wallta.gymbuddy;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class DayListActivity extends SingleFragmentActivity {

    private static final String EXTRA_DAY_ID = "wallta.gymbuddy.day_id";

    public static Intent newIntent(Context packageContext, UUID dayId) {
        Intent intent = new Intent(packageContext, DayListActivity.class);
        intent.putExtra(EXTRA_DAY_ID, dayId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return new DayListFragment();
    }


}
