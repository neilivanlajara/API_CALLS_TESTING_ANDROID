package com.example.api_calls_testing_android.ui.department;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.api_calls_testing_android.R;

public class DepartmentViewHolder extends RecyclerView.ViewHolder {
    private TextView depName = null;
    private TextView depId = null;


    public DepartmentViewHolder(@NonNull View itemView) {
        super(itemView);
        depName = itemView.findViewById(R.id.DepartmentNAME);
        depId = itemView.findViewById(R.id.DepartmentID);
    }

    public void updateContent(String depName, int id){
        this.depName.setText(depName);
        this.depId.setText(Integer.toString(id));

    }
}

