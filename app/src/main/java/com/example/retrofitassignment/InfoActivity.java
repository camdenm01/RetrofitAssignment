package com.example.retrofitassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class InfoActivity extends AppCompatActivity {

    private TextView descriptionText;
    private TextView locationText;
    private TextView dropsText;
    private ImageView imageView;
    private String name;
    private String description;
    private String locations;
    private String drops;
    private String image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        descriptionText = findViewById(R.id.info_text);
        locationText = findViewById(R.id.info_locations);
        dropsText = findViewById(R.id.info_drops);
        imageView = findViewById(R.id.info_image);

        Intent intent = getIntent();

        int id = intent.getIntExtra("id", 0);
        descriptionText.setText("Loading Information");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://botw-compendium.herokuapp.com/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI api = retrofit.create(RetrofitAPI.class);

        Call<Datum> call = api.getEntry(id); //use id passed form first api call to make a new call



        call.enqueue(new Callback<Datum>() {
            @Override
            public void onResponse(Call<Datum> call, Response<Datum> response) {
                if (!response.isSuccessful()) {
                    descriptionText.setText("Response not successful");
                    return;
                }

                Datum datum = response.body();
                Monster monster = datum.getMonster();
                name = monster.getName().toUpperCase();
                description = monster.getDescription();
                if (monster.getCommonLocations() != null) {
                    locations = monster.getCommonLocations().toString();
                    locations = locations.substring(1, locations.length() -1); //remove brackets from around string
                }
                if (monster.getDrops() != null) {
                    drops = monster.getDrops().toString();
                    drops = drops.substring(1, drops.length()-1);//removes brackets from string
                }
                image = monster.getImage();
                setTitle(name);
                descriptionText.setText(description);
                Picasso.with(InfoActivity.this).load(image).into(imageView);

                //location and drop list may be null as some creatures do not have this info
                if(locations == null || locations.length() == 0) locationText.setText("Locations: No information yet");
                else {
                    locationText.setText("Found in: " + locations);
                }
                if(drops == null || drops.length() == 0) dropsText.setText("Drops: No information yet");
                else {
                    dropsText.setText("Drops: " + drops);
                }



            }

            @Override
            public void onFailure(Call<Datum> call, Throwable t){
                descriptionText.setText(t.getMessage());
            }

    });
    }
}