package com.example.retrofitassignment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data{

    @SerializedName("data")
    private List<Monster> monsterList;


    public List<Monster> getMonsterList() {
        return monsterList;
    }
}
