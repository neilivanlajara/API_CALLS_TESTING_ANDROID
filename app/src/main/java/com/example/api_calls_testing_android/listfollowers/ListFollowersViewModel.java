package com.example.api_calls_testing_android.listfollowers;

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

public class ListFollowersViewModel extends AndroidViewModel {
    private final MutableLiveData<List<DepartmentInfo>> userListFollowerBuffer = new MutableLiveData<>(new ArrayList<>());


    public ListFollowersViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<DepartmentInfo>> getUserListFollowerBuffer (){
/*
        if (this.userListFollowerBuffer.getValue() != null && this.userListFollowerBuffer.getValue().size() == 0) feedUserListFollowerBuffer();
*/
        return this.userListFollowerBuffer;
    }
    public void destroyList(){
       userListFollowerBuffer.setValue(new ArrayList<>());
    }
    public void feedUserListFollowerBuffer(){
        GetWholeDepartmentListReadyRepository.getWholeDepartmentReady(
                list->{
                    if(list.getDepartmentInfos().size()==0){
                        Objects.requireNonNull(userListFollowerBuffer.getValue().add(new DepartmentInfo(-1, "No followers")));
                    }else{
                        for(DepartmentInfo e: list.getDepartmentInfos()){
                            Objects.requireNonNull(userListFollowerBuffer.getValue()).add(e);
                            userListFollowerBuffer.setValue(userListFollowerBuffer.getValue());
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