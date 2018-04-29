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

public class MuseumsSightseeingsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // Create a list of words
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(R.string.museums_akhun_tower, R.string.museums_akhun_tower_description, R.drawable.ic_akhun, R.drawable.akhun));
        places.add(new Place(R.string.museums_art_museum, R.string.museums_art_museum_description, R.drawable.ic_art_museum,
                             R.drawable.art_museum));
        places.add(new Place(R.string.museums_auto_sport_museum, R.string.museums_auto_sport_museum_description, R.drawable.ic_auto_musem, R.drawable.autodrom_museum));
        places.add(new Place(R.string.museums_marine_station, R.string.museums_marine_station_description, R.drawable.ic_marine_station, R.drawable.marine_station));
        places.add(new Place(R.string.museums_matsesta, R.string.museums_matsesta_description, R.drawable.ic_matsesta, R.drawable.matsesta));
        places.add(new Place(R.string.museums_tea_plantation, R.string.museums_tea_plantation_description, R.drawable.ic_tea_plantation, R.drawable.tea_houses));
        places.add(new Place(R.string.museums_singing_fontains, R.string.museums_singing_fontains_description, R.drawable.ic_singing_fontain, R.drawable.singing_fontains));
        places.add(new Place(R.string.museums_svyato_troitsky_temple, R.string.museums_svyato_troitsky_temple_description, R.drawable.ic_temple, R.drawable.temple));
        places.add(new Place(R.string.museums_of_sochi, R.string.museums_of_sochi_description, R.drawable.ic_museum_sochi, R.drawable.museum_sochi));
        places.add(new Place(R.string.museums_stalin_residence, R.string.museums_stalin_residence_description, R.drawable.ic_stalin_residence, R.drawable.stalin_residence));
        places.add(new Place(R.string.museums_train_station, R.string.museums_train_station_description, R.drawable.ic_train_station, R.drawable.train_station));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
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
