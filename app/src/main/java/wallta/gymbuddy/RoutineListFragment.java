package wallta.gymbuddy;

import android.os.Bundle;
import android.os.RecoverySystem;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RoutineListFragment extends Fragment {

    private Routine mRoutine;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRoutine = new Routine();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_routine_list, container, false);

        return view;
    }

    /**
     * --------------------------------------------------------------------------------------------
     * RoutineHolder
     * --------------------------------------------------------------------------------------------
     */

    private class RoutineHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Routine mRoutine;
        private TextView mNameTextView;

        public RoutineHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_routine, parent, false));
            itemView.setOnClickListener(this);

            mNameTextView = (TextView) itemView.findViewById(R.id.routine_name);
        }

        public void bind(Routine routine) {
            mRoutine = routine;
            mNameTextView.setText(mRoutine.getName());
        }

        @Override
        public void onClick(View view) {

        }
    }

    /**
     * --------------------------------------------------------------------------------------------
     * RoutineAdapter
     * --------------------------------------------------------------------------------------------
     */

    private class RoutineAdapter extends RecyclerView.Adapter<RoutineHolder> {

        private List<Routine> mRoutines;

        public RoutineAdapter(List<Routine> routines) {
            mRoutines = routines;
        }

        @Override
        public RoutineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new RoutineHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(RoutineHolder holder, int position) {
            Routine routine = mRoutines.get(position);
            holder.bind(routine);
        }

        @Override
        public int getItemCount() {
            return mRoutines.size();
        }

        public void setExercises(List<Routine> routines) {
            mRoutines = routines;
        }
    }
}
