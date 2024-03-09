package com.example.api_calls_testing_android.ui.department;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.api_calls_testing_android.R;
import com.example.api_calls_testing_android.model.DepartmentInfo;

import java.util.List;
import java.util.concurrent.Executor;

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentViewHolder> {
    private LayoutInflater inflater;
    private final Executor executor;

    private List<DepartmentInfo> users;



    public DepartmentAdapter(Context context, List<DepartmentInfo> users, Executor executor) {
        inflater = LayoutInflater.from(context);
        this.users = users;
        this.executor = executor;

    }

    @NonNull
    @Override
    public DepartmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.department_list_recycler_viewer, parent, false);

        return new DepartmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentViewHolder holder, int position) {
        DepartmentInfo singleDep = users.get(position);
        holder.updateContent(singleDep.getDisplayName(),singleDep.getDepartmentId(), singleDep.getImg() );
    }




    @Override
    public int getItemCount() {
        return users.size();
    }
}
