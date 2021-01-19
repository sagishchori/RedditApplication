package com.sagish.redditapplication.ui.main.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sagish.redditapplication.ui.main.models.ChildrenItem;
import com.sagish.redditapplication.ui.main.models.MainResponse;
import com.sagish.redditapplication.ui.main.repositories.MainRepository;
import com.sagish.redditapplication.ui.main.retrofit.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends AbstractViewModel {

    protected MutableLiveData<Result> result = new MutableLiveData<>();
    private MutableLiveData<List<ChildrenItem>> childrenList;

    public LiveData<List<ChildrenItem>> getChildrenItems() {
        if (childrenList == null) {
            childrenList = new MutableLiveData<>();
            loadData();
        }
        return childrenList;
    }

    public LiveData<Result> getResult() {
        return result;
    }

    private void loadData() {
        result.postValue(new Result.Loading());

        MainRepository.getInstance().getPageJSONObject("", new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                result.postValue(new Result.Success(null));
                MainResponse mainResponse = response.body();
                childrenList.postValue(mainResponse.getData().getChildren());
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                result.postValue(new Result.Error(t.getMessage()));
            }
        });
    }
}