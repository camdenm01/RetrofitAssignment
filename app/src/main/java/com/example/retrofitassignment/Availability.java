package com.example.retrofitassignment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Availability{

    @SerializedName("month-northern")
    @Expose
    private String monthNorthern;
    @SerializedName("month-southern")
    @Expose
    private String monthSouthern;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("isAllDay")
    @Expose
    private Boolean isAllDay;
    @SerializedName("isAllYear")
    @Expose
    private Boolean isAllYear;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("rarity")
    @Expose
    private String rarity;
    @SerializedName("month-array-northern")
    @Expose
    private List<Integer> monthArrayNorthern = null;
    @SerializedName("month-array-southern")
    @Expose
    private List<Integer> monthArraySouthern = null;
    @SerializedName("time-array")
    @Expose
    private List<Integer> timeArray = null;

    public String getMonthNorthern() {
        return monthNorthern;
    }

    public String getMonthSouthern() {
        return monthSouthern;
    }

    public String getTime() {
        return time;
    }

    public Boolean getAllDay() {
        return isAllDay;
    }

    public Boolean getAllYear() {
        return isAllYear;
    }

    public String getLocation() {
        return location;
    }

    public String getRarity() {
        return rarity;
    }

    public List<Integer> getMonthArrayNorthern() {
        return monthArrayNorthern;
    }

    public List<Integer> getMonthArraySouthern() {
        return monthArraySouthern;
    }

    public List<Integer> getTimeArray() {
        return timeArray;
    }
}
