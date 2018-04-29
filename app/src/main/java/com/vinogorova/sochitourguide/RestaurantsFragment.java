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

public class RestaurantsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // Create a list of words
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(R.string.cafe_delmar, R.string.cafe_delmar_description, R.drawable.delmar));
        places.add(new Place(R.string.cafe_chaika, R.string.cafe_chaika_description, R.drawable.chaika));
        places.add(new Place(R.string.cafe_brigantina, R.string.cafe_brigantina_description, R.drawable.brigantina));
        places.add(new Place(R.string.cafe_cho_kharcho, R.string.cafe_cho_kharcho_description, R.drawable.cho_kharcho));
        places.add(new Place(R.string.cafe_khmeli_suneli, R.string.cafe_khmeli_suneli_description, R.drawable.khmeli_suneli));
        places.add(new Place(R.string.cafe_lighthouse, R.string.cafe_lighthouse_description, R.drawable.lighthouse_4));
        places.add(new Place(R.string.cafe_vostochnyy_kvartal, R.string.cafe_vostochnyy_kvartal_description, R.drawable.vostochnyi_kvartal));
        places.add(new Place(R.string.cafe_baran_rapan, R.string.cafe_baran_rapan_description, R.drawable.baran_rapan));
        places.add(new Place(R.string.cafe_fettuchchine, R.string.cafe_fettuchchine_description, R.drawable.fettuccine));
        places.add(new Place(R.string.cafe_corks_wine, R.string.cafe_corks_wine_description, R.drawable.corks));

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
