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

public class CuriosityFragment extends Fragment {

    public CuriosityFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> attractions = new ArrayList<>();

        attractions.add(new Attraction(getString(R.string.sanpetronio_title), getString(R.string.sanpetronio_address), R.drawable.sanpetronio));
        attractions.add(new Attraction(getString(R.string.nettuno_title), getString(R.string.nettuno_address), R.drawable.statua_nettuno));
        attractions.add(new Attraction(getString(R.string.torri_title), getString(R.string.torri_address), R.drawable.torri_bologna));

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
