package nyc.c4q.marvelcomicsdb.controller;

import android.content.Context;
import android.content.Intent;
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
import java.util.zip.Inflater;
import nyc.c4q.marvelcomicsdb.DetailActivity;
import nyc.c4q.marvelcomicsdb.R;
import nyc.c4q.marvelcomicsdb.controller.CreatorAdapter.CreatorViewHolder;
import nyc.c4q.marvelcomicsdb.model.creator.Creator;
import nyc.c4q.marvelcomicsdb.service.RealmServiceManager;

/**
 * Created by c4q on 1/26/18.
 */

public class CreatorAdapter extends RecyclerView.Adapter<CreatorViewHolder> {

    Context context;
    List<Creator> creatorResponseList = new ArrayList<>();

    public CreatorAdapter(
            List<Creator> creatorResponseList) {
        this.creatorResponseList = creatorResponseList;
    }

    @Override
    public CreatorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.creator_item, parent, false);
        return new CreatorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CreatorViewHolder holder, int position) {
        StringBuilder url = new StringBuilder();

  @Override
  public void onBindViewHolder(CreatorViewHolder holder, final int position) {

    StringBuilder url = new StringBuilder();
    url.append(creatorResponseList.get(position).getThumbnail().getPath()).append(".")
        .append(creatorResponseList.get(position).getThumbnail().getExtension());
    String name = creatorResponseList.get(position).getFullName();
    holder.creatorName.setText(name);
    Picasso.with(context).load(url.toString()).into(holder.creatorThumbnail);

    holder.itemView.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Realm realmOnClick = RealmServiceManager.getRealm();
        realmOnClick.beginTransaction();
        realmOnClick.copyToRealmOrUpdate(creatorResponseList.get(position));
        realmOnClick.commitTransaction();

        Intent detailIntent = new Intent(context, DetailActivity.class);
        detailIntent.putExtra("object_type", "creator");
        detailIntent.putExtra("creator_id", creatorResponseList.get(position).getId());
        detailIntent.putExtra("creator_name", creatorResponseList.get(position).getFullName());
        context.startActivity(detailIntent);
      }
    });
  }

    }

    @Override
    public int getItemCount() {
        return (creatorResponseList == null) ? 0 : creatorResponseList.size();
    }

    public class CreatorViewHolder extends ViewHolder {

      public CreatorViewHolder(View itemView) {
      super(itemView);
      creatorThumbnail = itemView.findViewById(R.id.creator_thumbnail);
      creatorName = itemView.findViewById(R.id.creator_name);
      }
    }
}
