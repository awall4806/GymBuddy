package wallta.gymbuddy;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by awall4806 on 6/26/2017.
 */

public class ExerciseFragment extends Fragment {

    private Exercise mExercise;
    private AutoCompleteTextView mNameTextView;
    private Button mTimerButton;
    private TextView mSetsTextView;
    private TextView mTimerTextView;

    private static final String[] EXERCISES = new String[] {
            "BB Bench Press", "DB Curls", "BB Rows", "Lat Pulldown"
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mExercise = new Exercise();

        new CountDownTimer((long)mExercise.getSeconds()*1000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                mTimerTextView.setText((int)millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                int remainingReps = mExercise.getRemainingReps();
                if (remainingReps > 1) {
                    mExercise.setRemainingReps(remainingReps - 1);
                }
                else if(remainingReps == 1) {
                    mExercise.setCompleted(true);
                    // update Exercise List Item UI
                }
                // update UI
                // TODO: Set Off Alarm Upon Timer Finish
                mTimerTextView.setText(mExercise.getSeconds());
            }
        };
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercise, container, false);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, EXERCISES);
        mNameTextView = (AutoCompleteTextView) view.findViewById(R.id.exercise_name);
        mNameTextView.setAdapter(adapter);
        mNameTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // This space intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                mExercise.setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This space intentionally left blank
            }
        });

        mTimerButton = (Button) view.findViewById(R.id.timer_button);
        mTimerButton.setText(R.string.start_rest_timer);
        mTimerButton.setEnabled(true);

        mSetsTextView = (TextView) view.findViewById(R.id.sets_remaining);
        mSetsTextView.setText(mExercise.getReps() + "@string/sets_remaining");

        mTimerTextView = (TextView) view.findViewById(R.id.timer);
        mTimerTextView.setText(mExercise.getSeconds());

        return view;
    }
}
