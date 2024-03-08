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

public class DepartementListAdapter extends RecyclerView.Adapter<DepartmentViewHolder> {

    private LayoutInflater inflater;

    private List<DepartmentInfo> departmentInfos;

    public DepartementListAdapter(Context context, List<DepartmentInfo> departmentInfos) {
        inflater = LayoutInflater.from(context);
        this.departmentInfos = departmentInfos;
    }
    @NonNull
    @Override
    public DepartmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.featured_card_design, parent, false);

        return new DepartmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentViewHolder holder, int position) {
        DepartmentInfo singleDep = departmentInfos.get(position);
        holder.updateContent(singleDep.getDisplayName(),singleDep.getDepartmentId() );
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
