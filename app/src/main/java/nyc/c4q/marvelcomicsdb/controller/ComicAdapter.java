package nyc.c4q.marvelcomicsdb.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import io.realm.Realm;
import java.util.ArrayList;
import java.util.List;

import nyc.c4q.marvelcomicsdb.DetailActivity;
import nyc.c4q.marvelcomicsdb.R;
import nyc.c4q.marvelcomicsdb.controller.ComicAdapter.ComicViewHolder;
import nyc.c4q.marvelcomicsdb.model.comics.Comic;
import nyc.c4q.marvelcomicsdb.service.RealmServiceManager;

/**
 * Created by c4q on 1/26/18.
 */

public class ComicAdapter extends RecyclerView.Adapter<ComicViewHolder> {

  List<Comic> comicsList = new ArrayList<>();
  Context context;

  public ComicAdapter(List<Comic> comicsList) {
    this.comicsList = comicsList;
  }

  @Override
  public ComicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.comic_itemview, parent, false);
    context = parent.getContext();
    return new ComicViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ComicViewHolder holder, final int position) {
    StringBuilder url = new StringBuilder();
    url.append(comicsList.get(position).getThumbnail().getPath()).append(".")
        .append(comicsList.get(position).getThumbnail().getExtension());
    String name = comicsList.get(position).getTitle();
    holder.comicTitle.setText(name);
    Picasso.with(context).load(url.toString())
        .into(holder.comicThumbnail);

    holder.itemView.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Realm realmOnclick = RealmServiceManager.getRealm();
        realmOnclick.beginTransaction();
        realmOnclick.copyToRealmOrUpdate(comicsList.get(position));
        realmOnclick.commitTransaction();

        Intent detailIntent = new Intent(context, DetailActivity.class);
        detailIntent.putExtra("object_type", "comic");
        detailIntent.putExtra("comic_id", comicsList.get(position).getId());
        detailIntent.putExtra("comic_title", comicsList.get(position).getTitle());
        context.startActivity(detailIntent);
      }
    });
  }

  @Override
  public int getItemCount() {
    return (comicsList == null) ? 0 : comicsList.size();
  }

  public class ComicViewHolder extends ViewHolder {

    ImageView comicThumbnail;
    TextView comicTitle;

    public ComicViewHolder(View itemView) {
      super(itemView);
      comicThumbnail = itemView.findViewById(R.id.comic_thumbnail);
      comicTitle = itemView.findViewById(R.id.comic_name);
    }
  }
}
