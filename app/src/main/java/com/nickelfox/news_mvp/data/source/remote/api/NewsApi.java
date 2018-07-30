package com.nickelfox.news_mvp.data.source.remote.api;

import com.nickelfox.news_mvp.data.models.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    @GET("/top-headlines")
    Call<NewsResponse> getTopHeadlines(@Query("country") String country, @Query("category") String category);
}
