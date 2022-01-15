package com.example.movieapp.Model;

import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("poster_path")
    private String posterPath;
    private String imageUrl;
    private String title;
    private String desc;
    private String voteAverage;
    private String overview;
    private String release_date;
    private String original_language;
    public String getPosterPath() {
        return  "https://image.tmdb.org/t/p/w500" +posterPath;
    }

    public String getDesc() {
        return desc;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public String getTitle(){return  title;}

    public void setVoteAverage(String vote_average) {
        this.voteAverage = vote_average;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public Movie(String posterPath, String desc, String imageUrl, String title,String original_language,String release_date,String vote_average) {
        this.posterPath = posterPath;
        this.desc = desc;
        this.imageUrl = imageUrl;
        this.title=title;
        this.release_date=release_date;
        this.original_language=original_language;
        this.voteAverage=vote_average;
    }
}
