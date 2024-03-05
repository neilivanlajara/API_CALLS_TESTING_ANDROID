package com.example.api_calls_testing_android.model;

import com.google.gson.annotations.SerializedName;

public class DepartmentInfo {
    @SerializedName("departmentId")
    private int departmentId;


    @SerializedName("displayName")
    private String displayName;

    public DepartmentInfo(int departmentId, String displayName){
        this.departmentId = departmentId;
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getDepartmentId() {

        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
