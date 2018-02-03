package nyc.c4q.marvelcomicsdb.controller;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.marvelcomicsdb.R;
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
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        Picasso.with(context).load(articlesList.get(position).getUrlToImage())
                .into(holder.articleImage);

        String title = articlesList.get(position).getTitle();
        holder.articleTitle.setText(title);

        String author = articlesList.get(position).getAuthor();
        holder.articleAuthor.setText("By " + author);

        String description = articlesList.get(position).getDescription();
        holder.articleDescription.setText(description);
    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        ImageView articleImage;
        TextView articleTitle, articleAuthor, articleDescription;

        public NewsViewHolder(View itemView) {
            super(itemView);
            articleTitle = itemView.findViewById(R.id.article_title);
            articleAuthor = itemView.findViewById(R.id.article_author);
            articleDescription = itemView.findViewById(R.id.article_description);
            articleImage = itemView.findViewById(R.id.article_image);
        }
    }
}
