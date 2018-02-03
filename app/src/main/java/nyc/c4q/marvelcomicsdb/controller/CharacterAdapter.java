package nyc.c4q.marvelcomicsdb.controller;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import io.realm.Realm;
import nyc.c4q.marvelcomicsdb.DetailActivity;
import nyc.c4q.marvelcomicsdb.controller.CharacterAdapter.CharacterViewHolder;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.marvelcomicsdb.R;
import nyc.c4q.marvelcomicsdb.model.character.Character;
import nyc.c4q.marvelcomicsdb.service.RealmServiceManager;

/**
 * Created by c4q on 1/26/18.
 */

public class CharacterAdapter extends RecyclerView.Adapter<CharacterViewHolder> {

    List<Character> characterResultsList = new ArrayList<>();
    Context context;

    public CharacterAdapter(List<Character> characterResultsList) {
        this.characterResultsList = characterResultsList;
    }

    @Override
    public CharacterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.character_itemview, parent, false);
        context = parent.getContext();
        return new CharacterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CharacterViewHolder holder, final int position) {

        StringBuilder url = new StringBuilder();

        url.append(characterResultsList.get(position).getThumbnail().getPath()).append(".")
                .append(characterResultsList.get(position).getThumbnail().getExtension());

        Picasso.with(context).load(url.toString())
                .into(holder.thumbnail);
        String name = characterResultsList.get(position).getName();
        holder.characterName.setText(name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Realm realmOnclick = RealmServiceManager.getRealm();

                realmOnclick.beginTransaction();

                realmOnclick.copyToRealmOrUpdate(characterResultsList.get(position));

                List<Character> currentList = realmOnclick.where(Character.class).findAll();

                Log.d(TAG, "currentDBSize: " + currentList.size());

                realmOnclick.commitTransaction();

                Intent detailIntent = new Intent(context, DetailActivity.class);
                detailIntent.putExtra("object_type", "character");
                detailIntent.putExtra("char_id", characterResultsList.get(position).getId());
                detailIntent.putExtra("char_name", characterResultsList.get(position).getName());
                context.startActivity(detailIntent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return (characterResultsList == null) ? 0 : characterResultsList.size();
    }

    public class CharacterViewHolder extends ViewHolder {

        ImageView thumbnail;
        TextView characterName, description;
        Button favButton;


        public CharacterViewHolder(View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.character_thumbnail);
            characterName = itemView.findViewById(R.id.character_name);
            description = itemView.findViewById(R.id.detail_description);
            favButton = itemView.findViewById(R.id.favorite_button);
        }
    }
}
