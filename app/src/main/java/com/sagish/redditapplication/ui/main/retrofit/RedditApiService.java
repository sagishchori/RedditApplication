package com.sagish.redditapplication.ui.main.retrofit;

import com.sagish.redditapplication.ui.main.models.MainResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RedditApiService {

    @GET("{path}.json")
    Call<MainResponse> getJSONObject(@Path("path") String path);

    @GET("{path}.json")
    Call<List<MainResponse>> getJSONArray(@Path("path") String path);
}
