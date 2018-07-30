package com.nickelfox.news_mvp.top_headlines.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nickelfox.news_mvp.R;
import com.nickelfox.news_mvp.data.models.NewsArticle;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private Context context;
    private List<NewsArticle> newsArticles;

    NewsAdapter(Context context) {
        this.context = context;
        this.newsArticles = new ArrayList<>();
    }

    public void setData(List<NewsArticle> newsArticles){
        this.newsArticles = newsArticles;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsViewHolder(LayoutInflater.from(context).inflate(R.layout.news_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.newsTitle.setText(newsArticles.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return newsArticles.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.news_title)
        TextView newsTitle;
        NewsViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
