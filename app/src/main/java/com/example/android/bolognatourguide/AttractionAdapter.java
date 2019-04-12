package com.example.android.bolognatourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class AttractionAdapter extends ArrayAdapter<Attraction> {

    public static class ViewHolder {
        public TextView titleViewHolder, addressViewHolder;
        public ImageView picViewHolder;
    }

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param objects A List of Word objects to display in a list
     */
    public AttractionAdapter(Context context, ArrayList<Attraction> objects) {
        super(context, 0, objects);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listView = convertView;

        //I check if the view is being reused otherwise inflate the view
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.attraction_item_layout, parent, false);
            ViewHolder holder = new ViewHolder();

            holder.titleViewHolder = listView.findViewById(R.id.attraction_title);
            holder.addressViewHolder = listView.findViewById(R.id.attraction_address);
            holder.picViewHolder = listView.findViewById(R.id.attraction_pic);
            listView.setTag(holder);
        }

        //I get the current attraction
        Attraction currentAttraction = getItem(position);

        ViewHolder holder = (ViewHolder) listView.getTag();
        holder.titleViewHolder.setText(currentAttraction.getmTitle());
        holder.addressViewHolder.setText(currentAttraction.getmAddress());
        holder.picViewHolder.setImageResource(currentAttraction.getmPictureID());

        return listView;
    }
}
