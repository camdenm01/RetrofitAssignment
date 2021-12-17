package com.example.retrofitassignment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Datum{

    @SerializedName("data")
    private Monster monster;


    public Monster getMonster() {
        return monster;
    }
}
