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

public class ParksFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // Create a list of words
        final ArrayList <Place> places = new ArrayList<>();
        places.add(new Place(R.string.parks_riviera, R.string.parks_riviera_description,R.drawable.ic_riviera, R.drawable.riviera));
        places.add(new Place(R.string.parks_southern_cultures, R.string.parks_southern_cultures_description, R.drawable.ic_south_cultures, R.drawable.south_park));
        places.add(new Place(R.string.parks_olimpiyskiy, R.string.parks_olimpiyskiy_description, R.drawable.ic_olimpic_park, R.drawable.olimp_park));
        places.add(new Place(R.string.parks_potseluyevsky, R.string.parks_potseluyevsky_description, R.drawable.ic_potseluevdky_park, R.drawable.potseluevskiy));
        places.add(new Place(R.string.parks_ornithological, R.string.parks_ornithological_description, R.drawable.ic_ornitological_park, R.drawable.ornitological_park));
        places.add(new Place(R.string.parks_dendrariy, R.string.parks_dendrariy_description, R.drawable.ic_dendrariy, R.drawable.dendrariy));
        places.add(new Place(R.string.parks_komsomolskiy, R.string.parks_komsomolskiy_description, R.drawable.ic_komsomolsky, R.drawable.komsomolskiy));
        places.add(new Place(R.string.parks_russia_japan, R.string.parks_russia_japan_description, R.drawable.ic_russsia_japan,
                             R.drawable.russia_japan_garden));
        places.add(new Place(R.string.parks_sochi_park, R.string.parks_sochi_park_description, R.drawable.ic_sochi_park, R.drawable.sochi_park));

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
