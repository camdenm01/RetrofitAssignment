package com.example.retrofitassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class InfoActivity extends AppCompatActivity {

    private TextView descriptionText;
    private TextView locationText;
    private TextView dropsText;
    private ImageView imageView;
    private String description;
    private String locations;
    private String drops;
    private String image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent = getIntent();
        descriptionText = findViewById(R.id.info_text);
        locationText = findViewById(R.id.info_locations);
        dropsText = findViewById(R.id.info_drops);
        imageView = findViewById(R.id.info_image);
        description = intent.getStringExtra("description");
        locations = intent.getStringExtra("locations");
        drops = intent.getStringExtra("drops");
        image = intent.getStringExtra("image");
        descriptionText.setText(description);
        locationText.setText("Found in: " + locations);
        dropsText.setText("Drops: " + drops);
        Picasso.with(this).load(image).into(imageView);
    }
}