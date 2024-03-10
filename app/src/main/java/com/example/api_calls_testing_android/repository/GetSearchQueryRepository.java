package com.example.api_calls_testing_android.repository;

import com.example.api_calls_testing_android.communication.CommunicationAPI;

public class GetSearchQueryRepository {
    public static void getSearchQueryRepository(String query, OnSearchQueryReady onSearchQueryReady, FailedToCommunicate failedToCommunicate){
        CommunicationAPI.getSearchQuery(query, onSearchQueryReady, failedToCommunicate);
    }
}
