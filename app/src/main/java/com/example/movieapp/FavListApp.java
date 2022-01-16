package com.example.movieapp;

import android.app.Application;

import com.example.movieapp.Model.Movie;

import java.util.ArrayList;

public class FavListApp extends Application {
    private ArrayList<Movie> list;

    public  void addMovie(Movie movie)
    {
        list.add(movie);
    }

    public void setList(ArrayList<Movie> list) {
        this.list = list;
    }
    public ArrayList<Movie> getList() {
        return  this.list;
    }
    public FavListApp(){
        this.list=new ArrayList<>();
    }


}
