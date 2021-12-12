package com.example.retrofitassignment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Monster implements Comparable<Monster>{

    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("common_locations")
    @Expose
    private List<String> commonLocations;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("drops")
    @Expose
    private List<String> drops;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("name")
    @Expose
    private String name;

    public String getCategory() {
        return category;
    }

    public List<String> getCommonLocations() {
        return commonLocations;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getDrops() {
        return drops;
    }

    public Integer getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Monster monster) {
        String thisString = this.getName();
        String otherString = monster.getName();
        if(thisString.compareTo(otherString) < 0){
            return -1;
        }
        else if(thisString.compareTo(otherString) > 0){
            return 1;
        }
        else{
            return 0;
        }
    }
}
