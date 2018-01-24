package nyc.c4q.marvelcomicsdb.API;


import nyc.c4q.marvelcomicsdb.model.character.CharacterDataWrapper;
import nyc.c4q.marvelcomicsdb.model.comics.ComicDataWrapper;
import nyc.c4q.marvelcomicsdb.model.creator.CreatorDataWrapper;
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
    Call<ComicDataWrapper> getComicsDiscover(
            @Query("ts") String timestamp,
            @Query("apikey") String apiKey,
            @Query("hash") String hash
    );

    @GET("v1/public/creators?")
    Call<CreatorDataWrapper> getCreatorsDiscover(
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
    Call<ComicDataWrapper> sortComicsDiscover(
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
    Call<CreatorDataWrapper> sortCreatorsDiscover(
            @Query("ts") String timestamp,
            @Query("apikey") String apiKey,
            @Query("hash") String hash,
            @Query("firstName") String firstName,
            @Query("lastName") String lastName,
            @Query("comics") int comics,
            @Query("series") int series,
            @Query("events") int events,
            @Query("stories") int stories,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit,
            @Query("offset") int offset

    );
}
