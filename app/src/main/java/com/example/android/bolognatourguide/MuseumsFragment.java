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

import static com.example.android.bolognatourguide.Constants.*;

public class MuseumsFragment extends Fragment {

    public MuseumsFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> attractions = new ArrayList<>();

        attractions.add(new Attraction(getString(R.string.museo_civico_title), getString(R.string.museo_civico_address), R.drawable.museo_egizio, getString(R.string.museo_civico_desc)));
        attractions.add(new Attraction(getString(R.string.museo_resistenza_title), getString(R.string.museo_resistenza_address), R.drawable.museo_resistenza, getString(R.string.museo_resistenza_desc)));
        attractions.add(new Attraction(getString(R.string.museo_storia_title), getString(R.string.museo_storia_address), R.drawable.museo_storia, getString(R.string.museo_storia_desc)));

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
