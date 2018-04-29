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


public class EntertainmentsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // Create a list of words
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(R.string.entertainments_yacht_club, R.string.entertainments_yacht_club_description, R.drawable.yacht_club));
        places.add(new Place(R.string.entertainments_malibu_club, R.string.entertainments_malibu_club_description, R.drawable.maliby));
        places.add(new Place(R.string.entertainments_winter_theater, R.string.entertainments_winter_theater_description, R.drawable.winter_theater));
        places.add(new Place(R.string.entertainments_organ_hall, R.string.entertainments_organ_hall_description, R.drawable.organ_hall));
        places.add(new Place(R.string.entertainments_festivalniy, R.string.entertainments_festivalniy_description, R.drawable.festivalny));
        places.add(new Place(R.string.entertainments_treugolnik, R.string.entertainments_treugolnik_description, R.drawable.treugolnik));
        places.add(new Place(R.string.entertainments_horses, R.string.entertainments_horses_description, R.drawable.riding));
        places.add(new Place(R.string.entertainments_rafting, R.string.entertainments_rafting_description, R.drawable.rafting));
        places.add(new Place(R.string.entertainments_skypark, R.string.entertainments_skypark_description, R.drawable.skypark));
        places.add(new Place(R.string.entertainments_galaktika, R.string.entertainments_galaktika_description, R.drawable.galaktika));
        places.add(new Place(R.string.entertainments_mayak, R.string.entertainments_mayak_description, R.drawable.mayak));

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
