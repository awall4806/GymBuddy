package wallta.gymbuddy;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import java.util.UUID;

import static android.content.ContentValues.TAG;

/**
 * Created by awall4806 on 6/26/2017.
 */

public class ExerciseFragment extends Fragment {

    private static final String ARG_EXERCISE_ID = "exercise_id";

    private Exercise mExercise;
    private AutoCompleteTextView mNameTextView;
    private Button mTimerButton;
    private TextView mSetsTextView;
    private TextView mTimerTextView;
    private CountDownTimer mRestTimer;

    private static final String[] EXERCISES = new String[] {
            "BB Bench Press", "DB Curls", "BB Rows", "Lat Pulldown"
    };

    public static ExerciseFragment newInstance(UUID exerciseId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_EXERCISE_ID, exerciseId);

        ExerciseFragment fragment = new ExerciseFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID exerciseId = (UUID) getArguments().getSerializable(ARG_EXERCISE_ID);
        mExercise = GymBuddy.get(getActivity()).getExercise(exerciseId);

        mRestTimer = new CountDownTimer((long)mExercise.getSeconds()*1000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                mTimerTextView.setText((int)millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                int remainingSets = mExercise.getRemainingSets();
                if (remainingSets > 1) {
                    mExercise.setRemainingSets(remainingSets - 1);
                }
                else if(remainingSets == 1) {
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
        mTimerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTimerButton.getText().equals(R.string.start_rest_timer)) {
                    mRestTimer.start();
                    mTimerButton.setText(getString(R.string.stop_rest_timer));

                } else {
                    // TODO: Handle Stopping of Rest Timer
                }
            }
        });
        mTimerButton.setEnabled(true);

        mSetsTextView = (TextView) view.findViewById(R.id.sets_remaining);
        mSetsTextView.setText(mExercise.getSets() + " " + getString(R.string.sets_remaining));

        mTimerTextView = (TextView) view.findViewById(R.id.timer);
        mTimerTextView.setText("" + mExercise.getSeconds());

        return view;
    }
}
