package nyc.c4q.marvelcomicsdb.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.marvelcomicsdb.API.MarvelDBService;
import nyc.c4q.marvelcomicsdb.R;
import nyc.c4q.marvelcomicsdb.model.Characters;
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
        Call<Characters> charactersCall = marvelCallback.getCharactersDiscover("b50c206319ac5359d379de4d56395a7a","","","","",0);
        charactersCall.enqueue(new Callback<Characters>() {
            @Override
            public void onResponse(Call<Characters> call, Response<Characters> response) {

            }

            @Override
            public void onFailure(Call<Characters> call, Throwable t) {

            }
        });
    }
}
