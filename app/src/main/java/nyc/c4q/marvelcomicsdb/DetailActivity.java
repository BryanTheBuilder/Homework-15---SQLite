package nyc.c4q.marvelcomicsdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import io.realm.Realm;
import nyc.c4q.marvelcomicsdb.model.character.Character;
import nyc.c4q.marvelcomicsdb.model.comics.Comic;
import nyc.c4q.marvelcomicsdb.service.RealmServiceManager;

public class DetailActivity extends AppCompatActivity {

  private ImageView imageView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);
    imageView = findViewById(R.id.character_detail_image);
    Bundle extras = getIntent().getExtras();
    String object_type = extras.getString("object_type");
    realmReceptionSwitch(object_type , extras);
  }

  private void realmReceptionSwitch(String object_type , Bundle extras) {
    Realm realmRetrival = RealmServiceManager.getRealm();

    String path;
    String extension;
    switch (object_type) {
      case "character":
        Character character = realmRetrival.where(Character.class)
            .contains("name", extras.getString("Char_Name"))
            .findFirst();
        path = character.getThumbnail().getPath();
        extension = character.getThumbnail().getExtension();
        imageLoader(path, extension);
        break;
      case "comic":
        Comic comic = realmRetrival.where(Comic.class)
            .contains("title", extras.getString("comic_title"))
            .findFirst();
        path = comic.getThumbnail().getPath();
        extension = comic.getThumbnail().getExtension();
        imageLoader(path, extension);
        break;
    }


  }

  private void imageLoader(String path, String extension) {
    Picasso.with(getApplicationContext()).load(path + "." + extension).into(imageView);
  }


}
