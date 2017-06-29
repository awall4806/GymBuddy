package wallta.gymbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.UUID;

/**
 * Created by wallta on 6/26/2017.
 */

public class ExerciseListFragment extends Fragment {

    private static final String CLICKED_EXERCISE_POSITION = "clicked_exercise_position";

    private int clickedExercisePosition;

    private UUID mDayId;
    private RecyclerView mExerciseRecyclerView;
    private ExerciseAdapter mExerciseAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDayId = (UUID) getActivity().getIntent()
                .getSerializableExtra(ExerciseListActivity.EXTRA_DAY_ID);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercise_list, container, false);

        mExerciseRecyclerView = (RecyclerView) view.findViewById(R.id.exercise_recycler_view);
        mExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        if (savedInstanceState != null) {
            clickedExercisePosition = savedInstanceState.getInt(CLICKED_EXERCISE_POSITION);
        }

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putSerializable(CLICKED_EXERCISE_POSITION, clickedExercisePosition);
    }

    private void updateUI() {
        GymBuddy gymBuddy = GymBuddy.get(getActivity());
        List<Exercise> exercises = gymBuddy.getExercisesByDay(mDayId);

        if (mExerciseAdapter == null) {
            mExerciseAdapter = new ExerciseAdapter(exercises);
            mExerciseRecyclerView.setAdapter(mExerciseAdapter);
        } else {
            mExerciseAdapter.setExercises(exercises);
            mExerciseAdapter.notifyDataSetChanged();
        }
    }

    /**
     * --------------------------------------------------------------------------------------------
     * ExerciseHolder
     * --------------------------------------------------------------------------------------------
     */

    private class ExerciseHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private Exercise mExercise;
        private TextView mNameTextView;
        private TextView mCompletedTextView;

        public ExerciseHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_exercise, parent, false));
            itemView.setOnClickListener(this);

            mNameTextView = (TextView) itemView.findViewById(R.id.exercise_name);
            mCompletedTextView = (TextView) itemView.findViewById(
                    R.id.exercise_completed);
        }

        public void bind(Exercise exercise) {
            mExercise = exercise;
            mNameTextView.setText(mExercise.getName());
            mCompletedTextView.setVisibility(exercise.isCompleted() ?
                    View.VISIBLE : View.GONE);
        }

        @Override
        public void onClick(View view) {
            clickedExercisePosition = getAdapterPosition();
            Intent intent = ExerciseActivity.newIntent(getActivity(), mExercise.getDayId());
            startActivity(intent);
        }
    }

    /**
     * --------------------------------------------------------------------------------------------
     * ExerciseAdapter
     * --------------------------------------------------------------------------------------------
     */

    private class ExerciseAdapter extends RecyclerView.Adapter<ExerciseHolder> {

        private List<Exercise> mExercises;

        public ExerciseAdapter(List<Exercise> exercises) {
            mExercises = exercises;
        }

        @Override
        public ExerciseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new ExerciseHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ExerciseHolder holder, int position) {
            Exercise exercise = mExercises.get(position);
            holder.bind(exercise);
        }

        @Override
        public int getItemCount() {
            return mExercises.size();
        }

        public void setExercises(List<Exercise> exercises) {
            mExercises = exercises;
        }
    }
}
