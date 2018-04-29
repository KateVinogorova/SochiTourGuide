package com.vinogorova.sochitourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link TourGuideAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Place} objects.
 */
public class TourGuideAdapter extends ArrayAdapter {

    /**
     * Create a new {@link TourGuideAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param places is the list of {@link Place}s to be displayed.ds
     */
    TourGuideAdapter (Context context, ArrayList <Place> places){
        super(context, 0, places);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.places_list_item, parent, false);
        }

        // Get the {@link Place} object located at this position in the list
        Place  currentPlace = (Place)getItem(position);

        // Find the TextView in the places_list_item.xml layout with the ID place_name.
        TextView nameOfPlace = listItemView.findViewById(R.id.place_name);
        // Get the name of place from the currentPlace object and set this text on
        // the name TextView.
        nameOfPlace.setText(currentPlace.getName());

        // Find the ImageView in the places_list_item.xml layout with the ID image_view.
        ImageView imageView = listItemView.findViewById(R.id.image_view);

        if (currentPlace.hasImage()){
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentPlace.getIconResourceID());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        }else{
            // Otherwise hide the ImageView (set visibility to GONE
            imageView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
