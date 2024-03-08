package com.example.api_calls_testing_android.ui.department;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.api_calls_testing_android.model.DepartmentInfo;
import com.example.api_calls_testing_android.repository.GetWholeDepartmentListReadyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DepartmentViewModel extends AndroidViewModel {
    private final MutableLiveData<List<DepartmentInfo>> departmentList = new MutableLiveData<>(new ArrayList<>());


    public DepartmentViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<DepartmentInfo>> getDepartmentList(){
/*
        if (this.userListFollowerBuffer.getValue() != null && this.userListFollowerBuffer.getValue().size() == 0) feedUserListFollowerBuffer();
*/
        return this.departmentList;
    }
    public void destroyList(){
       departmentList.setValue(new ArrayList<>());
    }
    public void feedUserListFollowerBuffer(){
        GetWholeDepartmentListReadyRepository.getWholeDepartmentReady(
                list->{
                    Log.d("provando", "feedUserListFollowerBuffer: funziona");
                    if(list.getDepartmentInfos().size()==0){
                        Objects.requireNonNull(departmentList.getValue().add(new DepartmentInfo(-1, "No dep" )));
                    }else{
                        for(DepartmentInfo e: list.getDepartmentInfos()){
                            Objects.requireNonNull(departmentList.getValue()).add(e);
                            departmentList.setValue(departmentList.getValue());
                        }
/*
                        Objects.requireNonNull(userListFollowerBuffer.getValue()).add(list.get(0));
                        userListFollowerBuffer.setValue(userListFollowerBuffer.getValue());*/
                    }

                }, ()->{
                    Log.d("BELISSIMI ERRORI", "feedUserListFollowerBuffer: c'è qualcosa che non va qui :(  ");
                }
        );
    }


}