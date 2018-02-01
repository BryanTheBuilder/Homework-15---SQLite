package nyc.c4q.marvelcomicsdb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import io.realm.Realm;
import nyc.c4q.marvelcomicsdb.model.character.Character;
import nyc.c4q.marvelcomicsdb.service.RealmServiceManager;

public class DetailActivity extends AppCompatActivity {

  private ImageView imageView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);
    imageView = findViewById(R.id.character_detail_image);

    Realm realmRetrival = RealmServiceManager.getRealm();
    Bundle extras = getIntent().getExtras();

    String intentId = extras.getString("Char_Id");
    String intentString = extras.getString("Char_Name");

    Character character = realmRetrival.where(Character.class).contains("name", intentString)
        .findFirst();


    String path = character.getThumbnail().getPath();
    String extenstion = character.getThumbnail().getExtension();
    imageLoader(path, extenstion);
  }

  private void imageLoader(String path, String extension) {

    Picasso.with(getApplicationContext()).load(path + "." + extension).into(imageView);
  }


}
