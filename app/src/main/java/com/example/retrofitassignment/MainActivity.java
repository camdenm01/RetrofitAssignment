package com.example.retrofitassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private RecyclerView recyclerview;
    private LinearLayoutManager linearlayoutmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = findViewById(R.id.recycler_view);
        linearlayoutmanager = new LinearLayoutManager(MainActivity.this);
        linearlayoutmanager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(linearlayoutmanager);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://botw-compendium.herokuapp.com/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<Data> call = jsonPlaceHolderApi.getData();



        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if(!response.isSuccessful()){
                    result = findViewById(R.id.result);
                    result.setText(new Gson().toJson(response));
                    return;
                }


                result = findViewById(R.id.result);
                result.setText("Loading... There is a lot of data");
                Data data = response.body();
                List<Monster> monsterList = data.getMonsterList();
                RecyclerAdapter recycleradapter = new RecyclerAdapter(MainActivity.this, monsterList);
                recyclerview.setAdapter(recycleradapter);
                result.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

                result = findViewById(R.id.result);
                result.setText(t.getMessage());
            }
        });

    }
}