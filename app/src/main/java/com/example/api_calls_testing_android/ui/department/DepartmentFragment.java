package com.example.api_calls_testing_android.ui.department;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.api_calls_testing_android.R;
import com.example.api_calls_testing_android.model.DepartmentInfo;

import java.util.ArrayList;
import java.util.List;

public class DepartmentFragment extends Fragment {

    private DepartmentViewModel listFollowersViewModel;
    private DepartementListAdapter listFollowersAdapter;
    private RecyclerView recyclerView;



    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        this.listFollowersViewModel = new ViewModelProvider(this).get(DepartmentViewModel.class);
        listFollowersViewModel.feedUserListFollowerBuffer();




        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("LISTFOLLOWERS", "onActivityCreated: ");
        recyclerView = getView().findViewById(R.id.contactsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

/*
        viewPager = getView().findViewById(R.id.viewPagerListFollower);
*/
        DepartmentInfo prova = new DepartmentInfo(2, "ok");
        List<DepartmentInfo> e =     new ArrayList<>();
        e.add(prova);
        listFollowersAdapter = new DepartementListAdapter(getActivity(),e  );

        listFollowersViewModel.getDepartmentList().observe(getActivity(), v->{
            Log.d("provando", "onViewCreated: funziona"+listFollowersAdapter.getItemCount());
            listFollowersAdapter.notifyItemInserted( listFollowersViewModel.getDepartmentList().getValue().size()-1);
        });

        recyclerView.setAdapter(listFollowersAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}