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

public class ArticleViewModel extends AbstractViewModel {

    protected MutableLiveData<Result> result = new MutableLiveData<>();
    private String articleLink;

    private MutableLiveData<List<ChildrenItem>> childrenList;


    public LiveData<List<ChildrenItem>> getArticleItem() {
        if (childrenList == null) {
            childrenList = new MutableLiveData<>();
            loadArticle();
        }

        return childrenList;
    }

    public void setArticleLink(String link) {
        if (link.startsWith("/")) {
            link = link.substring(1);
        }
        this.articleLink = link;
    }

    public LiveData<Result> getResult() {
        return result;
    }

    private void loadArticle() {
        result.postValue(new Result.Loading());

        MainRepository.getInstance().getPageJSONArray(articleLink, new Callback<List<MainResponse>>() {
            @Override
            public void onResponse(Call<List<MainResponse>> call, Response<List<MainResponse>> response) {
                result.postValue(new Result.Success(null));
                MainResponse mainResponse = response.body().get(0);
                childrenList.postValue(mainResponse.getData().getChildren());
            }

            @Override
            public void onFailure(Call<List<MainResponse>> call, Throwable t) {
                result.postValue(new Result.Error(t.getMessage()));
            }
        });
    }
}
