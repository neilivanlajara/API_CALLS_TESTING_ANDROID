package com.example.api_calls_testing_android.model;

import com.google.gson.annotations.SerializedName;

public class Constituent {
    @SerializedName("constituentID")
    private int constituentID;

    @SerializedName("role")
    private String role;

    @SerializedName("name")
    private String name;

    @SerializedName("constituentULAN_URL")
    private String constituentULAN_URL;
    @SerializedName("title")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @SerializedName("constituentWikidata_URL")
    private String constituentWikidata_URL;

    @SerializedName("gender")
    private String gender;

    // Aggiungi i costruttori, i getter e i setter secondo necessità

    public int getConstituentID() {
        return constituentID;
    }

    public void setConstituentID(int constituentID) {
        this.constituentID = constituentID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConstituentULAN_URL() {
        return constituentULAN_URL;
    }

    public void setConstituentULAN_URL(String constituentULAN_URL) {
        this.constituentULAN_URL = constituentULAN_URL;
    }

    public String getConstituentWikidata_URL() {
        return constituentWikidata_URL;
    }

    public void setConstituentWikidata_URL(String constituentWikidata_URL) {
        this.constituentWikidata_URL = constituentWikidata_URL;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
