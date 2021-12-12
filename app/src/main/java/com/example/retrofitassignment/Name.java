package com.example.retrofitassignment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Name{

    @SerializedName("name-USen")
    @Expose
    private String nameUSen;
    @SerializedName("name-EUen")
    @Expose
    private String nameEUen;
    @SerializedName("name-EUde")
    @Expose
    private String nameEUde;
    @SerializedName("name-EUes")
    @Expose
    private String nameEUes;
    @SerializedName("name-USes")
    @Expose
    private String nameUSes;
    @SerializedName("name-EUfr")
    @Expose
    private String nameEUfr;
    @SerializedName("name-USfr")
    @Expose
    private String nameUSfr;
    @SerializedName("name-EUit")
    @Expose
    private String nameEUit;
    @SerializedName("name-EUnl")
    @Expose
    private String nameEUnl;
    @SerializedName("name-CNzh")
    @Expose
    private String nameCNzh;
    @SerializedName("name-TWzh")
    @Expose
    private String nameTWzh;
    @SerializedName("name-JPja")
    @Expose
    private String nameJPja;
    @SerializedName("name-KRko")
    @Expose
    private String nameKRko;
    @SerializedName("name-EUru")
    @Expose
    private String nameEUru;


    public String getNameUSen() {
        return nameUSen;
    }

    public String getNameEUen() {
        return nameEUen;
    }

    public String getNameEUde() {
        return nameEUde;
    }

    public String getNameEUes() {
        return nameEUes;
    }

    public String getNameUSes() {
        return nameUSes;
    }

    public String getNameEUfr() {
        return nameEUfr;
    }

    public String getNameUSfr() {
        return nameUSfr;
    }

    public String getNameEUit() {
        return nameEUit;
    }

    public String getNameEUnl() {
        return nameEUnl;
    }

    public String getNameCNzh() {
        return nameCNzh;
    }

    public String getNameTWzh() {
        return nameTWzh;
    }

    public String getNameJPja() {
        return nameJPja;
    }

    public String getNameKRko() {
        return nameKRko;
    }

    public String getNameEUru() {
        return nameEUru;
    }
}

