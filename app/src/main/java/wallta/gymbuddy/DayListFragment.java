package wallta.gymbuddy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

/**
 * Created by wallta on 6/26/2017.
 */

public class DayListFragment extends Fragment {

    private Day mDay;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDay = new Day();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day_list, container, false);

        Spinner spinner = (Spinner) view.findViewById(R.id.day_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.day_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void updateUI() {
        // TODO: Implement updateUI() method
    }

    /**
     * --------------------------------------------------------------------------------------------
     * DayHolder
     * --------------------------------------------------------------------------------------------
     */

    private class DayHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Day mDay;
        private Spinner mDaySpinner;

        public DayHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_day, parent, false));
            itemView.setOnClickListener(this);

            mDaySpinner = (Spinner) itemView.findViewById(R.id.day_spinner);
        }

        public void bind(Day day) {
            mDay = day;

        }

        @Override
        public void onClick(View view) {

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
