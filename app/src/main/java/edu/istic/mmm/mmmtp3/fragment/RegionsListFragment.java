package edu.istic.mmm.mmmtp3.fragment;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FilterQueryProvider;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import edu.istic.mmm.mmmtp3.R;
import edu.istic.mmm.mmmtp3.activity.RegionsListActivity;
import edu.istic.mmm.mmmtp3.adapter.RegionsArrayAdapter;
import edu.istic.mmm.mmmtp3.domain.Region;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegionsListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RegionsListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegionsListFragment extends Fragment {
    // UI Components
    private View fragmentView;
    private ListView listViewRegions;

    // Data & adapters
    private List<Region> regions;
    private RegionsArrayAdapter adapter;

    private OnFragmentInteractionListener mListener;

    public RegionsListFragment() {
        // Required empty public constrsuctor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void loadRegions() {
        regions = new ArrayList<>();
        regions.add(new Region("Bretagne"));
        regions.add(new Region("Alsace"));
        regions.add(new Region("Hauts-de-France"));
        regions.add(new Region("Provence-Alpes-Côte-d'Azure"));
        regions.add(new Region("Gascogne"));
    }

    private void setListViewAdapter() {
        adapter = new RegionsArrayAdapter(this.getActivity(), regions);
        listViewRegions.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentView = inflater.inflate(R.layout.fragment_regions_list, container, false);

        // UI Elements
        listViewRegions = (ListView) fragmentView.findViewById(R.id.listView_regions);

        // Initialize listview
        loadRegions();
        setListViewAdapter();

        // List selection handler
        listViewRegions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RegionsListFragment.this.handleListViewSelection(position);
            }
        });

        return fragmentView;
    }

    private void handleListViewSelection(int position) {
        Region region = regions.get(position);

        RegionsListActivity activity = (RegionsListActivity) getActivity();
        activity.onRegionSelected(region);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
