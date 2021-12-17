package com.example.retrofitassignment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitAPI {

    @GET("category/monsters")
    Call<Data> getData();

    @GET("entry/{id}")
    Call<Datum> getEntry(@Path(value="id") int entryId);

}
