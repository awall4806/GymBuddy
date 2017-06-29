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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;
import java.util.UUID;

/**
 * Created by wallta on 6/26/2017.
 */

public class DayListFragment extends Fragment {

    private static final String ARG_DAY_ID = "day_id";
    private static final String CLICKED_DAY_POSITION = "clicked_day_position";

    private int clickedDayPosition;

    private UUID mRoutineId;
    private RecyclerView mDayRecyclerView;
    private DayAdapter mDayAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRoutineId = (UUID) getActivity().getIntent()
                .getSerializableExtra(DayListActivity.EXTRA_ROUTINE_ID);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day_list, container, false);

        mDayRecyclerView = (RecyclerView) view.findViewById(R.id.day_recycler_view);
        mDayRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        if (savedInstanceState != null) {
            clickedDayPosition = savedInstanceState.getInt(CLICKED_DAY_POSITION);
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
        savedInstanceState.putSerializable(CLICKED_DAY_POSITION, clickedDayPosition);
    }

    private void updateUI() {
        GymBuddy gymBuddy = GymBuddy.get(getActivity());
        List<Day> days = gymBuddy.getDaysByRoutine(mRoutineId);

        if (mDayAdapter == null) {
            mDayAdapter = new DayAdapter(days);
            mDayRecyclerView.setAdapter(mDayAdapter);
        } else {
            mDayAdapter.setDays(days);
            mDayAdapter.notifyDataSetChanged();
        }
    }

    /**
     * --------------------------------------------------------------------------------------------
     * DayHolder
     * --------------------------------------------------------------------------------------------
     */

    private class DayHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
            AdapterView.OnItemSelectedListener {

        private Day mDay;
        private Spinner mDaySpinner;

        public DayHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_day, parent, false));
            itemView.setOnClickListener(this);

            mDaySpinner = (Spinner) itemView.findViewById(R.id.day_spinner);
            // Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.day_array));
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Apply the adapter to the spinner
            mDaySpinner.setAdapter(adapter);
            mDaySpinner.setOnItemSelectedListener(this);
        }

        public void bind(Day day) {
            mDay = day;
        }

        @Override
        public void onClick(View view) {
            clickedDayPosition = getAdapterPosition();
            Intent intent = ExerciseListActivity.newIntent(getActivity(), mDay.getDayId());
            startActivity(intent);
        }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            mDay.setDay(parent.getItemAtPosition(pos).toString());
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /**
     * --------------------------------------------------------------------------------------------
     * DayAdapter
     * --------------------------------------------------------------------------------------------
     */

    private class DayAdapter extends RecyclerView.Adapter<DayHolder> {

        private List<Day> mDays;

        public DayAdapter(List<Day> days) {
            mDays = days;
        }

        @Override
        public DayHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new DayHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(DayHolder holder, int position) {
            Day day = mDays.get(position);
            holder.bind(day);
        }

        @Override
        public int getItemCount() {
            return mDays.size();
        }

        public void setDays(List<Day> days) {
            mDays = days;
        }
    }
}
