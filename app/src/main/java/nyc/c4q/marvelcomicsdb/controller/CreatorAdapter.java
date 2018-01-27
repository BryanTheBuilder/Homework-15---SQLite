package nyc.c4q.marvelcomicsdb.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;
import nyc.c4q.marvelcomicsdb.R;
import nyc.c4q.marvelcomicsdb.controller.CreatorAdapter.CreatorViewHolder;
import nyc.c4q.marvelcomicsdb.model.creator.Creator;
import org.w3c.dom.Text;

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

  }

  @Override
  public int getItemCount() {
    return (creatorResponseList == null) ? 0 : creatorResponseList.size();
  }

  public class CreatorViewHolder extends ViewHolder {

    ImageView creatorThumbnail;
    TextView creatorName;

    public CreatorViewHolder(View itemView) {
      super(itemView);

    }
  }
}
