package com.example.api_calls_testing_android.communication;
import android.util.Log;

import com.example.api_calls_testing_android.model.Artwork;
import com.example.api_calls_testing_android.model.SearchQuery;
import com.example.api_calls_testing_android.model.WholeDepartmentList;
import com.example.api_calls_testing_android.repository.FailedToCommunicate;
import com.example.api_calls_testing_android.repository.OnArtworkReady;
import com.example.api_calls_testing_android.repository.OnSearchQueryReady;
import com.example.api_calls_testing_android.repository.OnWholeDepartmentListReady;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class CommunicationAPI {
    private static final String BASE_URL = "https://collectionapi.metmuseum.org/public/collection/v1/objects/";
    private static ApiInterface apiInterface;
    private final static String TAG = "Communication state";
    private int n = 0;
    private CommunicationAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface = retrofit.create(ApiInterface.class);
    }
    private static synchronized ApiInterface getInstanceOfCommunicator(){
        if (apiInterface     == null) new CommunicationAPI();
        return apiInterface;
    }
    public static void getWholeDepartmentList(OnWholeDepartmentListReady onWholeDepartmentListReady, FailedToCommunicate failedToCommunicate){
           String urlDep = "https://collectionapi.metmuseum.org/public/collection/v1/departments";
            getInstanceOfCommunicator().getWholeDepartmentList(urlDep).enqueue(new Callback<WholeDepartmentList>() {
                @Override
                public void onResponse(Call<WholeDepartmentList> call, Response<WholeDepartmentList> response) {
                    onWholeDepartmentListReady.onWholeDepartmentListReady(response.body());
                }

                @Override
                public void onFailure(Call<WholeDepartmentList> call, Throwable t) {

                }
            });
    }

    public static void getSearchQuery(String query, OnSearchQueryReady onSearchQueryReady, FailedToCommunicate failedToCommunicate){
        String urlQuery = "https://collectionapi.metmuseum.org/public/collection/v1/search?hasImages=true&q=";
        query.replace(" ", "+");

        getInstanceOfCommunicator().getSearchQuery(urlQuery+query   ).enqueue(
                new Callback<SearchQuery>() {
                    @Override
                    public void onResponse(Call<SearchQuery> call, Response<SearchQuery> response) {
                        Log.d(TAG, "onResponse: "+ response.body().getTotal()    );
                        onSearchQueryReady.onSearchQueryReady(response.body());
                    }

                    @Override
                    public void onFailure(Call<SearchQuery> call, Throwable t) {
                        Log.d(TAG, "onFailure: in searchQuery");
                    }
                }

        );
    }

    public static void getObject(int ArtWorkID, OnArtworkReady onObjectReady, FailedToCommunicate failedToCommunicate){
        getInstanceOfCommunicator().getObject( Integer.toString(ArtWorkID)).enqueue(new Callback<Artwork>() {
            @Override
            public void onResponse(Call<Artwork> call, Response<Artwork> response) {
                try{
                    onObjectReady.onArtworkReady(response.body());

                }catch (NullPointerException e){
                    Log.d("TAG", "onBindViewHolder: niente ");
                }

            }

            @Override
            public void onFailure(Call<Artwork> call, Throwable t) {
                Log.d(TAG, "onResponse: fallito");

            }
        });
    }
}
