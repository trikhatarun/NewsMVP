package com.nickelfox.news_mvp.data.source;

import android.support.annotation.NonNull;

public class NewsRepository implements NewsDataSource {
    private static NewsRepository instance = null;
    @NonNull
    private NewsDataSource newsLocalDataSource, newsRemoteDataSource;

    public static NewsRepository getInstance(@NonNull NewsDataSource newsLocalDataSource,
                                             @NonNull NewsDataSource newsRemoteDataSource) {
        if (instance == null) {
            instance = new NewsRepository(newsLocalDataSource, newsRemoteDataSource);
        }
        return instance;
    }

    public NewsRepository(@NonNull NewsDataSource newsLocalDataSource, @NonNull NewsDataSource newsRemoteDataSource) {
        this.newsLocalDataSource = newsLocalDataSource;
        this.newsRemoteDataSource = newsRemoteDataSource;
    }

    @Override
    public void getTopHeadlines(@NonNull GetNewsCallback callback) {
        newsRemoteDataSource.getTopHeadlines(callback);
    }
}
