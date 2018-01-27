package nyc.c4q.marvelcomicsdb.API;


import nyc.c4q.marvelcomicsdb.model.News.NewsDataWrapper;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsDBService {

    @GET("v2/everything?language=en&q=marvel&sources=fortune")
    Call<NewsDataWrapper> getNewsDiscover(
            @Query("apiKey") String apiKey
    );
}
