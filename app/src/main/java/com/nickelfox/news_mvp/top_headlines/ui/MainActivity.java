package com.nickelfox.news_mvp.top_headlines.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nickelfox.news_mvp.R;
import com.nickelfox.news_mvp.data.models.NewsArticle;
import com.nickelfox.news_mvp.data.source.NewsDataSource;
import com.nickelfox.news_mvp.data.source.NewsRepository;
import com.nickelfox.news_mvp.data.source.remote.NewsRemoteDataSource;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.news_list_RV) RecyclerView newsListRV;

    private NewsAdapter adapter;
    private NewsRepository newsRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        adapter = new NewsAdapter(this);

        newsListRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        newsListRV.setHasFixedSize(true);
        newsListRV.setAdapter(adapter);

        newsRepository = new NewsRepository(null, NewsRemoteDataSource.getInstance());

        newsRepository.getTopHeadlines(new NewsDataSource.GetNewsCallback() {
            @Override
            public void onTopHeadlinesLoaded(List<NewsArticle> newsArticles) {
                adapter.setData(newsArticles);
            }
        });

    }
}
