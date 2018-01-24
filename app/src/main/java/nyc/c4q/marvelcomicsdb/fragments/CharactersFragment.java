package nyc.c4q.marvelcomicsdb.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.marvelcomicsdb.API.MarvelDBService;
import nyc.c4q.marvelcomicsdb.R;
import nyc.c4q.marvelcomicsdb.model.CharacterDataWrapper;
import nyc.c4q.marvelcomicsdb.service.MarvelDatabaseServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharactersFragment extends Fragment {
    public static final MarvelDBService marvelCallback = MarvelDatabaseServiceGenerator.createService();
    private View rootView;

    public CharactersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_characters, container, false);

        return rootView;
    }

    public void getCharacterData(){
        Call<CharacterDataWrapper> charactersCall = marvelCallback.getCharactersDiscover();
        charactersCall.enqueue(new Callback<CharacterDataWrapper>() {
            @Override
            public void onResponse(Call<CharacterDataWrapper> call, Response<CharacterDataWrapper> response) {

            }

            @Override
            public void onFailure(Call<CharacterDataWrapper> call, Throwable t) {

            }
        });
    }
}
