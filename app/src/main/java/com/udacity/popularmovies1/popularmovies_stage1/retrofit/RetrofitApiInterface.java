package com.udacity.popularmovies1.popularmovies_stage1.retrofit;

import com.udacity.popularmovies1.popularmovies_stage1.model.ApiModel;
import com.udacity.popularmovies1.popularmovies_stage1.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by federico.creti on 16/02/2018.
 */

public interface RetrofitApiInterface {
    @GET("movie/top_rated")
    Call<ApiModel> topRatedsList(@Query("api_key") String apiKey);

    @GET("movie/popular")
    Call<ApiModel> popularsList(@Query("api_key") String apiKey);
}
