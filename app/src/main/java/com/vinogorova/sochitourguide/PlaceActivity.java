package com.vinogorova.sochitourguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PlaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set the content of the activity to use the activity_place.xml layout file
        setContentView(R.layout.activity_place);

        //Find LinaerLayout with ID layout_for_place_info in activity_place.xml
        LinearLayout layout = findViewById(R.id.layout_for_place_info);
        //Set background color to this LinearLayout
        layout.setBackgroundResource(R.color.background);

        //Find ImageView with ID picture in activity_place.xml
        ImageView imageView = findViewById(R.id.picture);
        //Set image resourse received from Intent
        imageView.setImageResource(getIntent().getIntExtra("picture", 0));

        //Find TextView with ID heading in activity_place.xml
        TextView heading = findViewById(R.id.heading);
        //Set name text received from Intent to the TextView with ID heading
        heading.setText(getIntent().getIntExtra("name", 0));

        TextView description = findViewById(R.id.description);
        //Set description text received from Intent to the TextView with ID heading
        description.setText(getIntent().getIntExtra("description", 0));
    }
}
