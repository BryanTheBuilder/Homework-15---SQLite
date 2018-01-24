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

    @GET("v1/public/comics?")
    Call<CharacterDataWrapper> getComicsDiscover(
            @Query("ts") String timestamp,
            @Query("apikey") String apiKey,
            @Query("hash") String hash
    );

    @GET("v1/public/creators?")
    Call<CharacterDataWrapper> getCreatorsDiscover(
            @Query("ts") String timestamp,
            @Query("apikey") String apiKey,
            @Query("hash") String hash
    );

    @GET("v1/public/characters?")
    Call<CharacterDataWrapper> sortCharactersDiscover(
            @Query("ts") String timestamp,
            @Query("apikey") String apiKey,
            @Query("hash") String hash,
            @Query("name") String name,
            @Query("comics") int comics,
            @Query("series") int series,
            @Query("events") int events,
            @Query("stories") int stories,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset
    );

    @GET("v1/public/comics?")
    Call<CharacterDataWrapper> sortComicsDiscover(
            @Query("ts") String timestamp,
            @Query("apikey") String apiKey,
            @Query("hash") String hash,
            @Query("format") String format,
            @Query("formatType") String formatType,
            @Query("noVariants") boolean noVariants,
            @Query("dateRange") int dateRange,
            @Query("title") String title,
            @Query("startYear") int startYear,
            @Query("issueNumber") int issueNumber,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset
    );

    @GET("v1/public/creators?")
    Call<CharacterDataWrapper> sortCreatorsDiscover(
            @Query("ts") String timestamp,
            @Query("apikey") String apiKey,
            @Query("hash") String hash
    );
}
