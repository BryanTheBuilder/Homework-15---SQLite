package nyc.c4q.marvelcomicsdb.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Date;

import nyc.c4q.marvelcomicsdb.API.MarvelDBService;
import nyc.c4q.marvelcomicsdb.R;
import nyc.c4q.marvelcomicsdb.model.character.CharacterDataWrapper;
import nyc.c4q.marvelcomicsdb.service.MarvelDatabaseServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharactersFragment extends Fragment {
    private static final String API_KEY = "b50c206319ac5359d379de4d56395a7a";
    private String name;
    private String nameStartsWith;
    private Date modifiedSince;
    private int comics;
    private int series;
    private int events;
    private int stories;
    private String orderBy;
    private int limit;
    private int offset;

    public static final MarvelDBService marvelCallback = MarvelDatabaseServiceGenerator.createService();
    private View rootView;

    public CharactersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_characters, container, false);
        getCharacterData();
        return rootView;
    }

    public void getCharacterData() {
        Call<CharacterDataWrapper> charactersCall = marvelCallback.getCharactersDiscover(API_KEY);
        charactersCall.enqueue(new Callback<CharacterDataWrapper>() {
            @Override
            public void onResponse(Call<CharacterDataWrapper> call, Response<CharacterDataWrapper> response) {
                Log.d("MARVEL CALLBACK", "onResponse: " + response.body().getData().getResults());
            }

            @Override
            public void onFailure(Call<CharacterDataWrapper> call, Throwable t) {
                Log.d("MARVEL CALLBACK", "onResponse: " + t.toString());
            }
        });
    }
}
