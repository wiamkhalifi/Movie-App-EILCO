package com.example.movieapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.movieapp.API.Client;
import com.example.movieapp.API.Service;
import com.example.movieapp.Adapter.MoviesAdapter;
import com.example.movieapp.Model.Genre;
import com.example.movieapp.Model.ListGenres;
import com.example.movieapp.Model.Movie;
import com.example.movieapp.Model.MoviesResponse;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public List<Movie> movies;
    ArrayList<Genre> genresList = new ArrayList<Genre>();
    BottomNavigationView btm;
    RecyclerView.LayoutManager llm;
  //  LinearLayoutManager linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvMov = (RecyclerView) findViewById(R.id.recyclerView);
        llm=new LinearLayoutManager(this);
       // linear=new LinearLayoutManager(this);
        rvMov.setLayoutManager(llm);

        btm = findViewById(R.id.bottom_navigation);
        btm.setSelectedItemId(R.id.action_popular);
        btm.setOnNavigationItemReselectedListener(navlistener);
        Client client = new Client();
        Service apiService = client.getClient().create(Service.class);
        Call<MoviesResponse> call = apiService.getPopularMovies(BuildConfig.THE_MOVIE_DB_API_TOKEN);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                List<Movie> movies= response.body().getResults();
                MoviesAdapter adapter = new MoviesAdapter(movies,genresList);
               // rvMov.setAdapter(adapter);
              //  rvMov.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                rvMov.setAdapter( adapter );
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                Log.d("Erreur !", t.getMessage());

            }
        });

        Call<ListGenres> call2 = apiService.listGenres(BuildConfig.THE_MOVIE_DB_API_TOKEN);
       call2.enqueue(new Callback<ListGenres>() {
           @Override
           public void onResponse(Call<ListGenres> call, Response<ListGenres> response) {
               genresList=response.body().getGenres();
           }

           @Override
           public void onFailure(Call<ListGenres> call, Throwable t) {
               System.out.println("Error " + t.getMessage());
               genresList = new ArrayList<Genre>();

           }
       });
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
