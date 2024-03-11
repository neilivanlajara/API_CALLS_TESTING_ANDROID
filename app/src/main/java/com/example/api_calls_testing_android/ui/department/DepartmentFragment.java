package com.example.api_calls_testing_android.ui.department;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.api_calls_testing_android.R;
import com.example.api_calls_testing_android.model.DepartmentInfo;

import java.util.List;

public class DepartmentFragment extends Fragment {

    private DepartmentViewModel departmentViewModel;
    private DepartmentAdapter departmentAdapter;
    private RecyclerView recyclerView;

    private String TAG = "ListFollowers";

    private GridLayoutManager layoutManager;

    private EditText editText;
    private ImageView logo;




    public static DepartmentFragment newInstance() {
        return new DepartmentFragment();
    }




    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        layoutManager = new GridLayoutManager(getContext(), 2);
        return inflater.inflate(R.layout.fragmemt_department, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.departmentViewModel = new ViewModelProvider(this).get(DepartmentViewModel.class);
        recyclerView = getView().findViewById(R.id.contactsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        departmentAdapter = new DepartmentAdapter(getActivity(), departmentViewModel.getDepartmentList().getValue() , getActivity().getMainExecutor() );


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.d(TAG, "onScrollStateChanged: "+newState);

            }
        });
        departmentViewModel.getDepartmentList().observe(getViewLifecycleOwner(), new Observer<List<DepartmentInfo>>() {
            @Override
            public void onChanged(List<DepartmentInfo> departmentInfos) {
                departmentAdapter.updateData(departmentInfos);
                departmentAdapter.notifyDataSetChanged();
            }
        });
        departmentViewModel.feedDepartmentList();

        recyclerView.setAdapter(departmentAdapter);



    }



}