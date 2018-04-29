package com.vinogorova.sochitourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NatureAttractionsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // Create a list of words
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(R.string.nature_agura_waterfalls, R.string.nature_agura_waterfalls_description, R.drawable.agura));
        places.add(new Place(R.string.nature_33_waterfalls, R.string.nature_33_waterfalls_description, R.drawable.waterfalls_33));
        places.add(new Place(R.string.nature_mamedovo_canyon, R.string.nature_mamedovo_canyon_description, R.drawable.mamedovo));
        places.add(new Place(R.string.nature_yew_and_boxtree, R.string.nature_yew_and_boxtree_description, R.drawable.tiso_samshitovaya));
        places.add(new Place(R.string.nature_krasnaya_polyana, R.string.nature_krasnaya_polyana_description, R.drawable.krasnaya_polyana));
        places.add(new Place(R.string.nature_eagle_rock, R.string.nature_eagle_rock_description, R.drawable.eagle_rock));
        places.add(new Place(R.string.nature_devils_gate_canyon, R.string.nature_devils_gate_canyon_description, R.drawable.devils_canyon));
        places.add(new Place(R.string.nature_vorontsovska_caves, R.string.nature_vorontsovska_caves_description, R.drawable.vorontsovskie));
        places.add(new Place(R.string.nature_akhtyrshskaya_cave, R.string.nature_akhtyrshskaya_cave_description, R.drawable.akhstirskaya));

        TourGuideAdapter tourGuideAdapter = new TourGuideAdapter(getActivity(), places);
        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // places_list.xml layout file.
        ListView listView = rootView.findViewById(R.id.list);

        //Set OnItemClickListener for the list of items
        //Pass information of selected item via Intent
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Place place = places.get(position);
                Intent intent = new Intent(getContext(), PlaceActivity.class);
                intent.putExtra("name", place.getName());
                intent.putExtra("description", place.getDescription());
                intent.putExtra("picture", place.getMainImageResourceID());
                startActivity(intent);
            }
        });

        //Set custom ArrayAdapter for ListView
        listView.setAdapter(tourGuideAdapter);

        return rootView;
    }

}
