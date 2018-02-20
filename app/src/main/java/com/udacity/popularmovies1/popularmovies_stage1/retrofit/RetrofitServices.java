package com.udacity.popularmovies1.popularmovies_stage1.retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by federico.creti on 16/02/2018.
 */

public final class RetrofitServices {
    private static Retrofit retrofit = null;
    private static final String BASE_URL = "http://api.themoviedb.org/3/";

    public static Retrofit getRetrofitInstance(){
        if (retrofit == null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
