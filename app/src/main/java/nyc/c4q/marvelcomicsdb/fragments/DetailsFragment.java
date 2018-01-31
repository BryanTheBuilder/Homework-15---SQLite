package nyc.c4q.marvelcomicsdb.fragments;


import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import io.realm.Realm;
import nyc.c4q.marvelcomicsdb.R;
import nyc.c4q.marvelcomicsdb.model.character.Character;
import nyc.c4q.marvelcomicsdb.service.RealmServiceManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {

  private View rootview;
  private ImageView rootImage;

  public DetailsFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    rootview = inflater.inflate(R.layout.fragment_details, container, false);
    rootImage = rootview.findViewById(R.id.characterImage);

    Realm realm = RealmServiceManager.getRealm();

    Bundle bundle = this.getArguments();
    String characterName = bundle.getString("Character_Name");
    int characterId = bundle.getInt("Character_Id");
    Character character = realm.where(Character.class).contains("name", characterName).findFirst();
    String extension = character.getThumbnail().getExtension();
    String link = character.getThumbnail().getPath();
    Log.d(TAG, "onRealmResponse: " + character.getName() +" "+ extension +" "+ link);


    String urlStirng = character.getThumbnail().getPath();
    String urlEndppoint = character.getThumbnail().getPath();

    Picasso.with(getContext()).load(urlStirng +"."+ urlEndppoint).into(rootImage);

    return rootview;
  }




}
