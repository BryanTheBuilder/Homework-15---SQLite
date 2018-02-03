package nyc.c4q.marvelcomicsdb.controller;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.marvelcomicsdb.MainActivity;
import nyc.c4q.marvelcomicsdb.R;
import nyc.c4q.marvelcomicsdb.fragments.WebFragment;
import nyc.c4q.marvelcomicsdb.model.News.Articles;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    List<Articles> articlesList = new ArrayList<>();
    Context context;

    public NewsAdapter(List<Articles> articlesList) {
        this.articlesList = articlesList;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_itemview, parent, false);
        context = parent.getContext();
        return new NewsViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, final int position) {
        Picasso.with(context).load(articlesList.get(position).getUrlToImage())
                .into(holder.articleImage);

        String title = articlesList.get(position).getTitle();
        holder.articleTitle.setText(title);

        String author = articlesList.get(position).getAuthor();
        holder.articleAuthor.setText("By " + author);

        String description = articlesList.get(position).getDescription();
        holder.articleDescription.setText(description);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle articleUrl = new Bundle();
                articleUrl.putString("webpage", articlesList.get(position).getUrl());

                WebFragment webFragment = new WebFragment();
                webFragment.setArguments(articleUrl);
                FragmentManager fragmentManager =((MainActivity) context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.drawer_layout, webFragment).addToBackStack("webstack");
                fragmentTransaction.commit();

                Log.d("Get Article",articlesList.get(position).getUrl());
            }
        });
    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        ImageView articleImage;
        TextView articleTitle, articleAuthor, articleDescription;
        WebView browser;

        public NewsViewHolder(View itemView) {
            super(itemView);
            articleTitle = itemView.findViewById(R.id.article_title);
            articleAuthor = itemView.findViewById(R.id.article_author);
            articleDescription = itemView.findViewById(R.id.article_description);
            articleImage = itemView.findViewById(R.id.article_image);

        }
    }
}
