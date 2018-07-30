package com.nickelfox.news_mvp.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsResponse {
    @SerializedName("status")
    private String status;
    @SerializedName("totalResults")
    private int totalResults;
    @SerializedName("articles")
    private List<NewsArticle> articleList;

    public NewsResponse(String status, int totalResults, List<NewsArticle> articleList) {
        this.status = status;
        this.totalResults = totalResults;
        this.articleList = articleList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<NewsArticle> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<NewsArticle> articleList) {
        this.articleList = articleList;
    }
}
