package nyc.c4q.marvelcomicsdb.fragments;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import io.realm.Realm;
import java.util.List;
import nyc.c4q.marvelcomicsdb.R;
import nyc.c4q.marvelcomicsdb.controller.CharacterAdapter;
import nyc.c4q.marvelcomicsdb.model.character.Character;
import nyc.c4q.marvelcomicsdb.service.RealmServiceManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesFragment extends Fragment {

  private static final String TAG = "REALM?";
  private TextView attributionText;
  private Realm favoritesRealm;
  private RecyclerView recyclerView;
  private CharacterAdapter characterAdapter;

  public FavoritesFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View rootView = inflater.inflate(R.layout.fragment_favorites, container, false);
    recyclerView = rootView.findViewById(R.id.character_favorites_rv);
    attributionText = rootView.findViewById(R.id.attributionText_cfavorites);
    favoritesRealm = RealmServiceManager.getRealm();

    List<Character> characterList = favoritesRealm.where(Character.class)
        .equalTo("isFavorite", true).findAll();


    for (Character chara : characterList) {
      Log.d(TAG, "onRealmResponse: " + chara.getName());
    }

    if (getActivity().getApplication().getResources().getConfiguration().orientation
        == Configuration.ORIENTATION_PORTRAIT) {
      recyclerView
          .setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 2));
    } else {
      recyclerView
          .setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 3));
    }

    characterAdapter = new CharacterAdapter(characterList);
    recyclerView.setAdapter(characterAdapter);
    return rootView;
  }

}
