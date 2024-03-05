package com.example.api_calls_testing_android.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WholeDepartmentList {
    @SerializedName("departments")
    private ArrayList<DepartmentInfo> departmentInfos;

    public ArrayList<DepartmentInfo> getDepartmentInfos() {
        return departmentInfos;
    }

    public void setDepartmentInfos(ArrayList<DepartmentInfo> departmentInfos) {
        this.departmentInfos = departmentInfos;
    }
}
