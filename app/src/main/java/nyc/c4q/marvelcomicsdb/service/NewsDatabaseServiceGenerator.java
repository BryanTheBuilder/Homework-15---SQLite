package nyc.c4q.marvelcomicsdb.service;


import nyc.c4q.marvelcomicsdb.API.MarvelDBService;
import nyc.c4q.marvelcomicsdb.API.NewsDBService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsDatabaseServiceGenerator {

    private static final String BASE_URL = "https://newsapi.org/";
    private static Retrofit.Builder builder =
            new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create());
    private static Retrofit retrofit = builder.build();
    private static HttpLoggingInterceptor loggingInterceptor =
            new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    private static OkHttpClient.Builder okhttpclient =
            new OkHttpClient.Builder();

    public static NewsDBService createService() {
        if (!okhttpclient.interceptors().contains(loggingInterceptor)) {
            okhttpclient.addInterceptor(loggingInterceptor);
            builder.client(okhttpclient.build());
            retrofit = builder.build();
        }
        return retrofit.create(NewsDBService.class);
    }
}
