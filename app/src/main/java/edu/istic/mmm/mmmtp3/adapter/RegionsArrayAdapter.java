package edu.istic.mmm.mmmtp3.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.istic.mmm.mmmtp3.R;
import edu.istic.mmm.mmmtp3.domain.Region;

/**
 * Created by maxime on 16/03/2016.
 */
public class RegionsArrayAdapter extends ArrayAdapter<Region> {
    private Activity activity;
    private List<Region> regions;
    private static LayoutInflater inflater = null;



    public RegionsArrayAdapter(Activity activity, List<Region> regions) {
        super(activity, 0, regions);
        try {
            this.activity = activity;
            this.regions = regions;
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        } catch (Exception e) {

        }
    }

    public int getCount() {
        return regions.size();
    }

    public Region getItem(Region position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        public TextView txt_region_name;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        final ViewHolder holder;
        try {
            if (convertView == null) {
                vi = inflater.inflate(R.layout.list_view_regionslist_row, null);
                holder = new ViewHolder();

                holder.txt_region_name = (TextView) vi.findViewById(R.id.regionslist_row_name);
                vi.setTag(holder);
            } else {
                holder = (ViewHolder) vi.getTag();
            }

            holder.txt_region_name.setText(regions.get(position).getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return vi;
    }
}
