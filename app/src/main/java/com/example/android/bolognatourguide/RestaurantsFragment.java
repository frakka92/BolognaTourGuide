package com.example.android.bolognatourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.android.bolognatourguide.Constants.INTENT_KEY_NAME_ADDRESS;
import static com.example.android.bolognatourguide.Constants.INTENT_KEY_NAME_DESCRIPTION;
import static com.example.android.bolognatourguide.Constants.INTENT_KEY_NAME_PICID;
import static com.example.android.bolognatourguide.Constants.INTENT_KEY_NAME_TITLE;

public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> attractions = new ArrayList<>();

        attractions.add(new Attraction(getString(R.string.tamburini_title), getString(R.string.tamburini_address), R.drawable.tamburini, getString(R.string.tamburini_desc)));
        attractions.add(new Attraction(getString(R.string.fourghetti_title), getString(R.string.fourghetti_address), R.drawable.fourghetti, getString(R.string.fourghetti_desc)));
        attractions.add(new Attraction(getString(R.string.laverace_title), getString(R.string.laverace_address), R.drawable.laverace, getString(R.string.laverace_desc)));

        AttractionAdapter attractionAdapter = new AttractionAdapter(getActivity(), attractions);

        final ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(attractionAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent attractionIntent = new Intent(getContext(), AttractionDetailActivity.class);
                Attraction attraction = (Attraction) listView.getItemAtPosition(position);

                //I want to display the details of the attraction so I need to pass the info as Extras
                Bundle b = new Bundle();
                b.putString(INTENT_KEY_NAME_TITLE, attraction.getmTitle());
                b.putString(INTENT_KEY_NAME_ADDRESS, attraction.getmAddress());
                b.putInt(INTENT_KEY_NAME_PICID, attraction.getmPictureID());
                b.putString(INTENT_KEY_NAME_DESCRIPTION, attraction.getmDescription());

                attractionIntent.putExtras(b);
                startActivity(attractionIntent);
            }
        });

        return listView;
    }
}
