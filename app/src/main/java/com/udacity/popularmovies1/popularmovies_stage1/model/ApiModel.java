package com.udacity.popularmovies1.popularmovies_stage1.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by federico.creti on 16/02/2018.
 */

public class ApiModel {
    private long page;
    private long totalResults;
    private long totalPages;
    private List<Movie> results = new ArrayList<Movie>();

    public void setPage(long page){
        this.page = page;
    }
    public long getPage(){
        return  page;
    }

    public void setTotalResults(long totalResults){
        this.totalResults = totalResults;
    }
    public long getTotalResults(){
        return totalResults;
    }

    public void setTotalPages(long totalPages){
        this.totalPages = totalPages;
    }
    public long getTotalPages(){
        return totalPages;
    }

    public void setResults(List<Movie> results){
        this.results = results;
    }
    public List<Movie> getResults(){
        return results;
    }
}
