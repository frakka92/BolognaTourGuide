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

public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> attractions = new ArrayList<>();

        attractions.add(new Attraction(getString(R.string.tamburini_title), getString(R.string.tamburini_address), R.drawable.tamburini));
        attractions.add(new Attraction(getString(R.string.fourghetti_title), getString(R.string.fourghetti_address), R.drawable.fourghetti));
        attractions.add(new Attraction(getString(R.string.laverace_title), getString(R.string.laverace_address), R.drawable.laverace));

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
