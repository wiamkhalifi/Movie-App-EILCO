package com.example.movieapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesResponse {

    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private List<Movie> results;
    @SerializedName("total_results")
    private  int totalResults;

    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public int getTotalResults() {
        return totalResults;
    }
    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public MoviesResponse(int page, List<Movie> results, int totalResults) {
        this.page = page;
        this.results = results;
        this.totalResults = totalResults;
    }
}
