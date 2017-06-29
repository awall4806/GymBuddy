package wallta.gymbuddy;

import android.support.v4.app.Fragment;

/**
 * Created by wallta on 6/28/2017.
 */

public class ExerciseActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ExerciseFragment();
    }
}
