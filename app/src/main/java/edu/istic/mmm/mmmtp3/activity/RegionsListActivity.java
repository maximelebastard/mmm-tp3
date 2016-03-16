package edu.istic.mmm.mmmtp3.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import edu.istic.mmm.mmmtp3.R;
import edu.istic.mmm.mmmtp3.domain.Region;
import edu.istic.mmm.mmmtp3.fragment.RegionsDetailFragment;
import edu.istic.mmm.mmmtp3.fragment.RegionsListFragment;

public class RegionsListActivity extends AppCompatActivity implements RegionsDetailFragment.OnFragmentInteractionListener, RegionsListFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vins);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (savedInstanceState != null) {
            return;
        }

        // Init left fragment
        RegionsListFragment listFragment = new RegionsListFragment();
        listFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction()
                .add(R.id.vins_list_fragment, listFragment).commit();


        // Init right fragment
        if (findViewById(R.id.vins_details_fragment) != null) {
            RegionsDetailFragment detailFragment = new RegionsDetailFragment();
            detailFragment.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction()
                    .add(R.id.vins_details_fragment, detailFragment).commit();

            detailFragment.updateUrl("http://google.com");
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void onRegionSelected(Region region) {
        RegionsDetailFragment viewer = (RegionsDetailFragment) getFragmentManager()
                .findFragmentById(R.id.vins_details_fragment);

        if (viewer == null) {
            Intent showContent = new Intent(getApplicationContext(),
                    RegionsDetailActivity.class);
            showContent.setData(Uri.parse(region.getUrl()));
            startActivity(showContent);
        } else {
            viewer.updateUrl(region.getUrl());
        }
    }
}
