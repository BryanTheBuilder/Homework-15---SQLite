package nyc.c4q.marvelcomicsdb.API;


import nyc.c4q.marvelcomicsdb.model.Characters;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarvelDBService {

    @GET("v1/public/characters?")
    Call<Characters> getCharactersDiscover(
            @Query("api_key") String apikey,
            @Query("name") String name,
            @Query("comics") String comics,
            @Query("series") String series,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit
    );
}
