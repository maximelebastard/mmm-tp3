package edu.istic.mmm.mmmtp3.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import edu.istic.mmm.mmmtp3.R;
import edu.istic.mmm.mmmtp3.fragment.RegionsDetailFragment;
import edu.istic.mmm.mmmtp3.fragment.RegionsListFragment;

public class RegionsDetailActivity extends AppCompatActivity implements RegionsDetailFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_vins);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (savedInstanceState != null) {
            return;
        }

        // Load Fragment
        RegionsDetailFragment detailFragment = new RegionsDetailFragment();
        detailFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction()
                .add(R.id.vins_details_fragment, detailFragment).commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
