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

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import nyc.c4q.marvelcomicsdb.API.MarvelDBService;
import nyc.c4q.marvelcomicsdb.R;
import nyc.c4q.marvelcomicsdb.Utils.PrivateAPI;
import nyc.c4q.marvelcomicsdb.controller.CreatorAdapter;
import nyc.c4q.marvelcomicsdb.model.comics.CreatorList;
import nyc.c4q.marvelcomicsdb.model.creator.Creator;
import nyc.c4q.marvelcomicsdb.model.creator.CreatorDataWrapper;
import nyc.c4q.marvelcomicsdb.service.MarvelDatabaseServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreatorFragment extends Fragment {

  public static final MarvelDBService marvelCallback = MarvelDatabaseServiceGenerator
      .createService();
  private static final String API_KEY = "b50c206319ac5359d379de4d56395a7a";
  private static final Long TIMESTAMP = new Date().getTime();
  private static String privateAPI = PrivateAPI.getPrivateApiKey();
  private View rootView;
  private TextView attributionText;
  private RecyclerView recyclerView;
  CreatorAdapter creatorAdapter;
  List<Creator> creatorList = new ArrayList<>();


  public CreatorFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    rootView = inflater.inflate(R.layout.fragment_creator, container, false);
    attributionText = rootView.findViewById(R.id.attributionText_creator);
    recyclerView = rootView.findViewById(R.id.creator_rv);

    if (getActivity().getApplication().getResources().getConfiguration().orientation
        == Configuration.ORIENTATION_PORTRAIT) {
      recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
    } else {
      recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
    }

    try {
      getCreatorData();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return rootView;
  }

  public void getCreatorData() throws NoSuchAlgorithmException {
    String hash = md5(TIMESTAMP.toString() + privateAPI + API_KEY);
    Call<CreatorDataWrapper> call = marvelCallback
        .getCreatorsDiscover(TIMESTAMP.toString(), API_KEY, hash);
    call.enqueue(new Callback<CreatorDataWrapper>() {
      @Override
      public void onResponse(Call<CreatorDataWrapper> call, Response<CreatorDataWrapper> response) {
        Log.d("CREATOR CALLBACK", "onResponse: " + response.body().getEtag());
        attributionText.setText(response.body().getAttributionText());
        List<Creator> responseList = response.body().getData().getResults();
        recyclerView.setAdapter(new CreatorAdapter(responseList));
      }

      @Override
      public void onFailure(Call<CreatorDataWrapper> call, Throwable t) {
        Log.d("CREATOR CALLBACK", "onFailure: " + t.toString());
      }
    });
  }

  public String md5(String s) {
    try {
      final MessageDigest digest = MessageDigest.getInstance("md5");
      digest.update(s.getBytes());
      final byte[] bytes = digest.digest();
      final StringBuilder sb = new StringBuilder();
      for (int i = 0; i < bytes.length; i++) {
        sb.append(String.format("%02X", bytes[i]));
      }
      return sb.toString().toLowerCase();
    } catch (Exception exc) {
      return "";
    }
  }
}
