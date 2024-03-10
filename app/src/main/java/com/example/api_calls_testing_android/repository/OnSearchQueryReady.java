package com.example.api_calls_testing_android.repository;

import com.example.api_calls_testing_android.model.Artwork;
import com.example.api_calls_testing_android.model.SearchQuery;

public interface OnSearchQueryReady {
    public void onSearchQueryReady(SearchQuery searchQuery) throws Exception;

}
