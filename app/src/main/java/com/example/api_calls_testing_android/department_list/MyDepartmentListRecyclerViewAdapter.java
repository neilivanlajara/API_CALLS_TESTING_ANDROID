package com.example.api_calls_testing_android.department_list;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.api_calls_testing_android.department_list.WholeDepartmentListModel.PlaceholderItem;
import com.example.api_calls_testing_android.databinding.FragmentItem2Binding;
import com.example.api_calls_testing_android.model.DepartmentInfo;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyDepartmentListRecyclerViewAdapter extends RecyclerView.Adapter<MyDepartmentListRecyclerViewAdapter.ViewHolder> {

    private final List<DepartmentInfo> mValues;

    public MyDepartmentListRecyclerViewAdapter(List<DepartmentInfo> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentItem2Binding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        /*holder.mItem = mValues.get(position).;*/
        holder.mIdView.setText(mValues.get(position).getDisplayName());
        holder.mContentView.setText(mValues.get(position).getDepartmentId());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public PlaceholderItem mItem;

        public ViewHolder(FragmentItem2Binding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}