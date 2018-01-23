package nyc.c4q.marvelcomicsdb.API;


import nyc.c4q.marvelcomicsdb.models.characters.Characters;
import nyc.c4q.marvelcomicsdb.models.comics.Comics;
import nyc.c4q.marvelcomicsdb.models.comics.Creators;
import nyc.c4q.marvelcomicsdb.models.series.Series;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarvelDBService {
    @GET("v1/public/comics?")
    Call<Comics> getComicsDiscover(
            @Query("api_key") String apikey,
            @Query("series") String series,
            @Query("title") String title,
            @Query("creators") String creators,
            @Query("format") String format,
            @Query("dateDescriptor") String dateDescriptor,
            @Query("orderBy") String orderBy,
            @Query("dateRange") int dateRange,
            @Query("limit") int limit
    );

    @GET("v1/public/characters?")
    Call<Characters> getCharactersDiscover(
            @Query("api_key") String apikey,
            @Query("name") String name,
            @Query("comics") String comics,
            @Query("series") String series,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit
    );

    @GET("v1/public/series?")
    Call<Series> getSeriesDiscover(
            @Query("api_key") String apikey,
            @Query("title") String title,
            @Query("comics") String comics,
            @Query("creators") String creators,
            @Query("characters") String characters,
            @Query("orderBy") String orderBy,
            @Query("seriesType") String seriesType,
            @Query("startYear") int startYear,
            @Query("limit") int limit
    );

    @GET("v1/public/creators")
    Call<Creators> getCreatorsDoscover(
            @Query("api_key") String apikey,
            @Query("firstName") String firstName,
            @Query("lastName")String lastName,
            @Query("orderBy") String orderBy,
            @Query("limit") int limit
    );
}
