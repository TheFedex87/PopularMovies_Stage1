package com.udacity.popularmovies1.popularmovies_stage1.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by federico.creti on 16/02/2018.
 */

public class Movie {
    @SerializedName("vote_count")
    private int voteCount;
    @SerializedName("id")
    private long id;
    @SerializedName("video")
    private boolean video;
    @SerializedName("vote_average")
    private float voteAverage;
    @SerializedName("title")
    private String title;
    @SerializedName("popularity")
    private float popularity;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("genre_ids")
    private List<Integer> genreIds = new ArrayList<Integer>();
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("adult")
    private Boolean adult;
    @SerializedName("overview")
    private String overview;
    @SerializedName("release_date")
    private String releaseDate;

    public void setVoteCount(int voteCount){
        this.voteCount = voteCount;
    }
    public int getVoteCount(){
        return voteCount;
    }

    public void setId(long id){
        this.id = id;
    }
    public long getId(){
        return id;
    }

    public void setVideo(boolean video){
        this.video = video;
    }
    public boolean getVideo(){
        return video;
    }

    public void setVoteAverage(float voteAverage){
        this.voteAverage = voteAverage;
    }
    public float getVoteAverage(){
        return voteAverage;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }

    public void setPopularity(float popularity){
        this.popularity = popularity;
    }
    public float getPopularity(){
        return  popularity;
    }

    public void setPosterPath(String posterPath){
        this.posterPath = posterPath;
    }
    public String getPosterPath(){
        return  posterPath;
    }

    public void setOriginalLanguage(String originalLanguage){
        this.originalLanguage = originalLanguage;
    }
    public String getOriginalLanguage(){
        return  originalLanguage;
    }

    public void setOriginalTitle(String originalTitle){
        this.originalTitle = originalTitle;
    }
    public String getOriginalTitle(){
        return  originalTitle;
    }

    public void setGenreIds(List<Integer> genreIds){
        this.genreIds = genreIds;
    }
    public List<Integer> getGenreIds(){
        return genreIds;
    }

    public void setBackdropPath(String backdropPath){
        this.backdropPath = backdropPath;
    }
    public String getBackdropPath(){
        return backdropPath;
    }

    public void setAdult(boolean adult){
        this.adult = adult;
    }
    public boolean getAdult(){
        return adult;
    }

    public void setOverview(String overview){
        this.overview = overview;
    }
    public String getOverview(){
        return overview;
    }

    public void setReleaseDate(String releaseDate){
        this.releaseDate = releaseDate;
    }
    public String getReleaseDate(){
        return releaseDate;
    }
}

