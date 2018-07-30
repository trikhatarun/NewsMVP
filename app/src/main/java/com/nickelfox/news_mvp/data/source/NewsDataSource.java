package com.nickelfox.news_mvp.data.source;

import android.support.annotation.NonNull;

import com.nickelfox.news_mvp.data.models.NewsArticle;

import java.util.List;

public interface NewsDataSource {
    interface GetNewsCallback {
        void onTopHeadlinesLoaded(List<NewsArticle> newsArticles);
    }

    void getTopHeadlines(@NonNull GetNewsCallback callback);
}
