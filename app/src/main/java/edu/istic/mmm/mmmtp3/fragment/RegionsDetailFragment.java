package edu.istic.mmm.mmmtp3.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

import edu.istic.mmm.mmmtp3.R;
import edu.istic.mmm.mmmtp3.activity.RegionsListActivity;
import edu.istic.mmm.mmmtp3.domain.Region;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegionsDetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RegionsDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegionsDetailFragment extends Fragment {
    public static final String ARG_REGIONNAME = "region_name";

    // UI Components
    private View fragmentView;
    private WebView webview;
    private Button btLocate;

    private String regionName;

    private OnFragmentInteractionListener mListener;

    public RegionsDetailFragment() {
        // Required empty public constructor
    }

    public void updateUrl(String newUrl) {
        if (webview != null) {
            webview.loadUrl(newUrl);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentView = inflater.inflate(R.layout.fragment_regions_detail, container, false);

        // UI Components
        webview = (WebView) fragmentView.findViewById(R.id.regions_detail_webview);
        btLocate = (Button) fragmentView.findViewById(R.id.bt_locate);

        // Read intent bundle and load url if given
        Bundle extras = getActivity().getIntent().getExtras();
        if(extras != null) {
            String url = getActivity().getIntent().getExtras().getString(ARG_REGIONNAME);
            if(url != null) {
                updateUrl(url);
            }
        }

        // Locate handler
        btLocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegionsDetailFragment.this.handleLocateBtClick();
            }
        });

        return fragmentView;
    }

    private void handleLocateBtClick() {
        RegionsListActivity activity = (RegionsListActivity) getActivity();
        activity.onLocateRequested(new Region("Toto"));
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
