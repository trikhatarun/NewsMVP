package com.nickelfox.news_mvp.data.source.remote;

import android.support.annotation.NonNull;

import com.nickelfox.news_mvp.data.models.NewsResponse;
import com.nickelfox.news_mvp.data.source.NewsDataSource;
import com.nickelfox.news_mvp.data.source.remote.api.NewsApi;
import com.nickelfox.news_mvp.data.source.remote.api.NewsClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRemoteDataSource implements NewsDataSource {
    private static final NewsRemoteDataSource instance = new NewsRemoteDataSource();

    public static NewsRemoteDataSource getInstance() {
        return instance;
    }

    private NewsRemoteDataSource() {
    }

    @Override
    public void getTopHeadlines(@NonNull final GetNewsCallback callback) {
        NewsApi newsApi = NewsClient.getClient().create(NewsApi.class);

        newsApi.getTopHeadlines("us", "business").enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(@NonNull Call<NewsResponse> call, @NonNull Response<NewsResponse> response) {
                callback.onTopHeadlinesLoaded(response.body().getArticleList());
            }

            @Override
            public void onFailure(@NonNull Call<NewsResponse> call, @NonNull Throwable t) {

            }
        });
    }
}
