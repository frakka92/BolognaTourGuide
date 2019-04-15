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

public class CulturesFragment extends Fragment {

    public CulturesFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> attractions = new ArrayList<>();

        attractions.add(new Attraction(getString(R.string.sanpetronio_title), getString(R.string.sanpetronio_address), R.drawable.sanpetronio, getString(R.string.sanpetronio_desc)));
        attractions.add(new Attraction(getString(R.string.nettuno_title), getString(R.string.nettuno_address), R.drawable.statua_nettuno, getString(R.string.nettuno_desc)));
        attractions.add(new Attraction(getString(R.string.torri_title), getString(R.string.torri_address), R.drawable.torri_bologna, getString(R.string.torri_desc)));

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
