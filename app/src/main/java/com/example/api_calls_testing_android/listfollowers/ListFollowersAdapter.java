package com.example.api_calls_testing_android.listfollowers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.api_calls_testing_android.R;
import com.example.api_calls_testing_android.model.DepartmentInfo;
import com.example.api_calls_testing_android.ui.department.DepartmentViewHolder;

import java.util.List;
import java.util.concurrent.Executor;

public class ListFollowersAdapter extends RecyclerView.Adapter<ListFollowersViewHolder> {
    private LayoutInflater inflater;
    private final Executor executor;

    private List<DepartmentInfo> users;



    public ListFollowersAdapter(Context context, List<DepartmentInfo> users, Executor executor) {
        inflater = LayoutInflater.from(context);
        this.users = users;
        this.executor = executor;

    }

    @NonNull
    @Override
    public ListFollowersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_follower_viewer, parent, false);

        return new ListFollowersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListFollowersViewHolder holder, int position) {
        DepartmentInfo singleDep = users.get(position);
        holder.updateContent(singleDep.getDisplayName(),singleDep.getDepartmentId() );
    }




    @Override
    public int getItemCount() {
        return users.size();
    }
}
