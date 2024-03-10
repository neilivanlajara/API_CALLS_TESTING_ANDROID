package com.example.api_calls_testing_android.model;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Artwork {


    public Artwork(String title) {
        this.title = title;
    }

    @SerializedName("period")
    private String period;

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    @SerializedName("isHighlight")
    private boolean isHighLight;

    public boolean isHighLight() {
        return isHighLight;
    }

    public void setHighLight(boolean highLight) {
        isHighLight = highLight;
    }

    @SerializedName("message")
    private String message;
    @SerializedName("title")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isPublicDomain() {
        return isPublicDomain;
    }

    public String getPrimaryImageSmall() {
        return primaryImageSmall;
    }

    public void setPrimaryImageSmall(String primaryImageSmall) {
        this.primaryImageSmall = primaryImageSmall;
    }

    public String getPrimaryImage() {
        return primaryImage;
    }

    public void setPrimaryImage(String primaryImage) {
        this.primaryImage = primaryImage;
    }

    public void setPublicDomain(boolean publicDomain) {
        isPublicDomain = publicDomain;
    }

    @SerializedName("objectID")
    private int objectID;


    @SerializedName("constituents")
    private List<Constituent> constituents;


    public List<Constituent> getConstituents() {
        return constituents;
    }

    public void setConstituents(List<Constituent> constituents) {
        this.constituents = constituents;
    }

    @SerializedName("accessionYear")
    private String accessionYear;

    @SerializedName("isPublicDomain")
    private boolean isPublicDomain;

    @SerializedName("primaryImage")
    private String primaryImage;

    @SerializedName("primaryImageSmall")
    private String primaryImageSmall;

    public String getAccessionYear() {
        return accessionYear;
    }

    public void setAccessionYear(String accessionYear) {
        this.accessionYear = accessionYear;
    }

    public int getObjectID() {
        return objectID;
    }

    public void setObjectID(int objectID) {
        this.objectID = objectID;
    }
}
