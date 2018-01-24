package nyc.c4q.marvelcomicsdb.API;


import java.util.Date;

import nyc.c4q.marvelcomicsdb.model.character.CharacterDataWrapper;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarvelDBService {

    @GET("v1/public/characters?")
    Call<CharacterDataWrapper> getCharactersDiscover(
            @Query("ts") String timestamp,
            @Query("apikey") String apiKey,
            @Query("hash") String hash
    );

    @GET("v1/public/characters?")
    Call<CharacterDataWrapper> sortCharactersDiscover(
            @Query("apikey") String apiKey,
            @Query("name") String name,
            @Query("nameStartsWith") String nameStartsWith,
            @Query("modifiedSince") Date modifiedSince,
            @Query("comics") int comics,
            @Query("series") int series,
            @Query("events") int events,
            @Query("stories") int stories,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset
    );
}
