package com.example.retrofitassignment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("category/monsters")
    Call<Data> getData();
}
