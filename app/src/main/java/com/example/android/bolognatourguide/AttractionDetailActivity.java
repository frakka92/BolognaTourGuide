package com.example.android.bolognatourguide;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.android.bolognatourguide.Constants.*;

public class AttractionDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attraction_details_layout);

        //I get the attraction info if exists otherwise it will throw a NullPointerException and the app will crash
        if (getIntent().getExtras() != null) {
            Attraction attraction = getIntent().getParcelableExtra(INTENT_KEY_NAME_PARCELABLE);

            ActionBar ab = getSupportActionBar();
            ab.setTitle(attraction.getmTitle());

            TextView titleTextView = findViewById(R.id.attraction_details_title);
            TextView addressTextView = findViewById(R.id.attraction_details_address);
            ImageView picImageView = findViewById(R.id.attraction_details_pic);
            TextView descriptionTextView = findViewById(R.id.attraction_details_description);

            titleTextView.setText(attraction.getmTitle());
            addressTextView.setText(attraction.getmAddress());
            picImageView.setImageResource(attraction.getmPictureID());
            descriptionTextView.setText(attraction.getmDescription());
        }
    }
}
