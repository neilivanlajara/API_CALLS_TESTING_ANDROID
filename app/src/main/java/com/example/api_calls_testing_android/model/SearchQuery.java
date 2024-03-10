package com.example.api_calls_testing_android.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchQuery {

    @SerializedName("total")
    private int total;

    @SerializedName("objectIDs")
    private List<Integer> artworks;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Integer> getArtworks() {
        return artworks;
    }

    public void setArtworks(List<Integer> artworks) {
        this.artworks = artworks;
    }
}
