package com.example.movieapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.movieapp.Adapter.MoviesAdapter;
import com.example.movieapp.Model.Movie;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class FavActivity extends AppCompatActivity {
    BottomNavigationView btm;
    RecyclerView.LayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);
        btm = findViewById(R.id.bottom_navigation_fav);
        btm.setSelectedItemId(R.id.action_favorite);
        btm.setOnNavigationItemReselectedListener(navlistener);
        FavListApp app = (FavListApp) getApplicationContext();
        ArrayList<Movie> liste= app.getList();
        MoviesAdapter adapter = new MoviesAdapter(liste,null);
        llm=new LinearLayoutManager(this);



        RecyclerView rv_movies = (RecyclerView) findViewById(R.id.rvFavmovies);
        rv_movies.setLayoutManager(llm);




       // adapter.notifyDataSetChanged();
        rv_movies.setAdapter(adapter);
        rv_movies.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
    private BottomNavigationView.OnNavigationItemReselectedListener navlistener =
            new BottomNavigationView.OnNavigationItemReselectedListener() {
                @Override
                public void onNavigationItemReselected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.action_popular:
                            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            getApplicationContext().startActivity(intent);
                            break;
                        case R.id.action_upcoming:
                            Intent upcoming=new Intent(getApplicationContext(),UpComingActivity.class);
                            upcoming.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            getApplicationContext().startActivity(upcoming);

                            break;

                        case  R.id.action_favorite:
                            Intent fav=new Intent(getApplicationContext(),FavActivity.class);
                            fav.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            getApplicationContext().startActivity(fav);
                    }


                }
            };
}
