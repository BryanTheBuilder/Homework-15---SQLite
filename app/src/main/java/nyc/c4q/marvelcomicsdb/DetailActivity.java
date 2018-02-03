package nyc.c4q.marvelcomicsdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import nyc.c4q.marvelcomicsdb.controller.CharacterAdapter;
import nyc.c4q.marvelcomicsdb.model.character.Character;
import nyc.c4q.marvelcomicsdb.model.character.CharacterStoryList;
import nyc.c4q.marvelcomicsdb.model.comics.Comic;
import nyc.c4q.marvelcomicsdb.model.creator.Creator;
import nyc.c4q.marvelcomicsdb.service.RealmServiceManager;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = "Detail Button Click";
    private ImageView imageView;
    private TextView charName, charDesc;
    private Button favButton;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imageView = findViewById(R.id.detail_thumbnail);
        charName = findViewById(R.id.detail_name_title);
        charDesc = findViewById(R.id.detail_description);
        favButton = findViewById(R.id.favorite_button);
        recyclerView = findViewById(R.id.detail_rv);

        Bundle extras = getIntent().getExtras();
        String object_type = extras.getString("object_type");
        realmReceptionSwitch(object_type, extras);
    }

    private void realmReceptionSwitch(String object_type, Bundle extras) {
        Realm realmRetrieval = RealmServiceManager.getRealm();

        String path;
        String extension;


        switch (object_type) {

            case "character":
                final Character character = realmRetrieval.where(Character.class)
                        .contains("name", extras.getString("char_name"))
                        .findFirst();

                path = character.getThumbnail().getPath();
                extension = character.getThumbnail().getExtension();

                imageLoader(path, extension);
                dataLoader(character);

                favButton.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        favButton.setBackgroundResource(R.drawable.added_to_wishlist);
                        Realm realm = RealmServiceManager.getRealm();
                        realm.beginTransaction();
                        character.setFavorite(true);
                        realm.copyToRealmOrUpdate(character);

                        Toast.makeText(getApplicationContext(), "added to favorites", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "onButtonClick: " + String.valueOf(character.getFavorite()));
                        realm.commitTransaction();
                    }
                });
                break;

            case "comic":
                final Comic comic = realmRetrieval.where(Comic.class)
                        .contains("title", extras.getString("comic_title"))
                        .findFirst();
                path = comic.getThumbnail().getPath();
                extension = comic.getThumbnail().getExtension();
                imageLoader(path, extension);

                favButton.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        favButton.setBackgroundResource(R.drawable.added_to_wishlist);
                        Realm realm = RealmServiceManager.getRealm();
                        realm.beginTransaction();
                        comic.setFavorite(true);
                        realm.copyToRealmOrUpdate(comic);
                        realm.commitTransaction();
                    }
                });
                break;

            case "creator":
                final Creator creator = realmRetrieval.where(Creator.class)
                        .contains("fullName", extras.getString("creator_id"))
                        .findFirst();
                path = creator.getThumbnail().getPath();
                extension = creator.getThumbnail().getExtension();
                imageLoader(path, extension);
                favButton.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        favButton.setBackgroundResource(R.drawable.added_to_wishlist);
                        Realm realm = RealmServiceManager.getRealm();
                        realm.beginTransaction();
                        creator.setFavorite(true);
                        realm.copyToRealmOrUpdate(creator);
                        realm.commitTransaction();
                    }
                });
                break;
        }
    }

    private void imageLoader(String path, String extension) {
        Picasso.with(getApplicationContext()).load(path + "." + extension).into(imageView);
    }

    private void dataLoader(Character character) {
        charName.setText(character.getName());
        charDesc.setText(character.getDescription());

    }
}
