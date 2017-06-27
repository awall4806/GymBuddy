package wallta.gymbuddy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wallta on 6/26/2017.
 */

public class ExerciseListFragment extends Fragment {

    private Exercise mExercise;
    private int clickedExercisePosition;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mExercise = new Exercise();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercise_list, container, false);

        return view;
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
            //Intent intent = GymActivity.newIntent(getActivity(), mExercise.getId());
            //startActivity(intent);
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
