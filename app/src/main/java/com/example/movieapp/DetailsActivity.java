package com.example.movieapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.movieapp.Model.Movie;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    ArrayList<String> movieGenres;
    String gr= "";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_details);
        FloatingActionButton btn=(FloatingActionButton) findViewById(R.id.addFav);
        ImageView header=(ImageView) findViewById(R.id.detail_movie_cover);
        ImageView movImage= (ImageView)findViewById(R.id.detail_movie_img);
        TextView movTitle=(TextView)findViewById(R.id.detail_movie_title);
        TextView langage=(TextView)findViewById(R.id.detail_movie_lang);
        TextView date=(TextView)findViewById(R.id.detail_movie_date);
        TextView descr=(TextView)findViewById(R.id.detail_movie_desc);
        TextView genre=(TextView) findViewById(R.id.genre);

        Intent intent1=getIntent();
       // if(intent1.hasExtra("title"))

            String img=getIntent().getExtras().getString("image");
            String movieName=getIntent().getExtras().getString("title");
            String synopsis=getIntent().getExtras().getString("description");
            String dateRel=getIntent().getExtras().getString("date");
            String lang=getIntent().getExtras().getString("langage");
            movieGenres = (ArrayList<String>) getIntent().getSerializableExtra("genres");

            Glide.with(this).load(img).into(movImage);

            movTitle.setText(movieName);
            descr.setText(synopsis);
            date.setText(dateRel);
            langage.setText(lang);

        for(int i = 0; i<movieGenres.size();i++)
        {
            gr = gr +" - "+ movieGenres.get(i);

        }
            genre.setText(gr);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Movie movie=new Movie(img
                            , null, null, movieName
                            ,null,null,null);
                    Intent intent_favorite=new Intent(getApplicationContext(),FavActivity.class);
                    FavListApp app = (FavListApp) getApplicationContext();
                    ArrayList<Movie> list=app.getList();
                    app.addMovie(movie);
                    intent_favorite.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplicationContext().startActivity(intent_favorite);

                }
            });

        }

    }

