package com.example.api_calls_testing_android.repository;

import com.example.api_calls_testing_android.communication.CommunicationAPI;

public class GetWholeDepartmentListReadyRepository {
    public static void getWholeDepartmentReady(OnWholeDepartmentListReady onWholeDepartmentListReady, FailedToCommunicate failedToCommunicate){
        CommunicationAPI.getWholeDepartmentList( onWholeDepartmentListReady, failedToCommunicate);
    }
}
