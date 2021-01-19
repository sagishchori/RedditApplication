package com.sagish.redditapplication.ui.main.repositories;

import com.sagish.redditapplication.ui.main.models.MainResponse;
import com.sagish.redditapplication.ui.main.retrofit.RedditApiService;
import com.sagish.redditapplication.ui.main.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Callback;

public class MainRepository {

    private static MainRepository sInstance = null;

    private MainRepository() {

    }

    public static MainRepository getInstance() {
        if (sInstance == null) {
            sInstance = new MainRepository();
        }

        return sInstance;
    }

    public static void getPageJSONObject(String path, Callback<MainResponse> callback) {
        RedditApiService service = RetrofitClient.bindService(RedditApiService.class);
        service.getJSONObject(path).enqueue(callback);
    }

    public void getPageJSONArray(String articleLink, Callback<List<MainResponse>> callback) {
        RedditApiService service = RetrofitClient.bindService(RedditApiService.class);
        service.getJSONArray(articleLink).enqueue(callback);
    }
}
