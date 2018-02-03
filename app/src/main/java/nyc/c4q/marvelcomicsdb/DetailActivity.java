package nyc.c4q.marvelcomicsdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import io.realm.Realm;
import nyc.c4q.marvelcomicsdb.model.character.Character;
import nyc.c4q.marvelcomicsdb.model.comics.Comic;
import nyc.c4q.marvelcomicsdb.model.creator.Creator;
import nyc.c4q.marvelcomicsdb.service.RealmServiceManager;

public class DetailActivity extends AppCompatActivity {

  private static final String TAG = "Detail Button Click";
  private ImageView imageView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);
    imageView = findViewById(R.id.character_detail_image);
    Bundle extras = getIntent().getExtras();
    String object_type = extras.getString("object_type");
    realmReceptionSwitch(object_type, extras);
  }

  private void realmReceptionSwitch(String object_type, Bundle extras) {
    Realm realmRetrival = RealmServiceManager.getRealm();

    String path;
    String extension;
    switch (object_type) {
      case "character":
        final Character character = realmRetrival.where(Character.class)
            .contains("name", extras.getString("char_name"))
            .findFirst();
        path = character.getThumbnail().getPath();
        extension = character.getThumbnail().getExtension();
        imageLoader(path, extension);
        imageView.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {

            Realm realm = RealmServiceManager.getRealm();
            realm.beginTransaction();
            character.setFavorite(true);
            if (realm.where(Character.class).contains("name", character.getName())
                .equalTo("isFavorite", false).count() == 1) {
              realm.copyToRealmOrUpdate(character);
            }
            Toast.makeText(getApplicationContext(), "added to favorites", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onButtonClick: " + String.valueOf(character.getFavorite()));
            realm.commitTransaction();
          }
        });
        break;
      case "comic":
        final Comic comic = realmRetrival.where(Comic.class)
            .contains("title", extras.getString("comic_title"))
            .findFirst();
        path = comic.getThumbnail().getPath();
        extension = comic.getThumbnail().getExtension();
        imageLoader(path, extension);
        imageView.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
            comic.setFavorite(true);
            Realm realm = RealmServiceManager.getRealm();
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(comic);
            realm.commitTransaction();
          }
        });
        break;
      case "creator":
        final Creator creator = realmRetrival.where(Creator.class)
            .contains("fullName", extras.getString("creator_id"))
            .findFirst();
        path = creator.getThumbnail().getPath();
        extension = creator.getThumbnail().getExtension();
        imageLoader(path, extension);
        imageView.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
            creator.setFavorite(true);
            Realm realm = RealmServiceManager.getRealm();
            realm.beginTransaction();
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


}
