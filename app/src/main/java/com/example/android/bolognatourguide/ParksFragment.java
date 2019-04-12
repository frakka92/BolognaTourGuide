package com.example.android.bolognatourguide;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ParksFragment extends Fragment {

    public ParksFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> attractions = new ArrayList<>();

        attractions.add(new Attraction(getString(R.string.villachigi_title), getString(R.string.villachigi_address), R.drawable.parco_villachigi));
        attractions.add(new Attraction(getString(R.string.viagiardini_title), getString(R.string.viagiardini_address), R.drawable.parco_viagiardini));
        attractions.add(new Attraction(getString(R.string.giardinimargherita_title), getString(R.string.giardinimargherita_address), R.drawable.giardini_margherita));

        AttractionAdapter attractionAdapter = new AttractionAdapter(getActivity(), attractions);

        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(attractionAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "Item", Toast.LENGTH_SHORT).show();
            }
        });

        return listView;
    }
}
