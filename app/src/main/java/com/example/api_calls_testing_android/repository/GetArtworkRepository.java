package com.example.api_calls_testing_android.repository;

import com.example.api_calls_testing_android.communication.CommunicationAPI;

public class GetArtworkRepository {
    public static void getObject(int ArtWorkID,OnArtworkReady onObjectReady, FailedToCommunicate failedToCommunicate){
        CommunicationAPI.getObject( ArtWorkID, onObjectReady, failedToCommunicate);
    }
}
