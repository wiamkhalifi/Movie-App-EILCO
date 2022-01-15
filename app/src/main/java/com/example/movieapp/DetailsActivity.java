package com.example.movieapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ImageView header=(ImageView) findViewById(R.id.detail_movie_cover);
        ImageView movImage= (ImageView)findViewById(R.id.detail_movie_img);
        TextView movTitle=(TextView)findViewById(R.id.detail_movie_title);
        TextView langage=(TextView)findViewById(R.id.detail_movie_lang);
        TextView date=(TextView)findViewById(R.id.detail_movie_date);
        TextView descr=(TextView)findViewById(R.id.detail_movie_desc);

        Intent intent1=getIntent();
        if(intent1.hasExtra("title"))
        {
            String img=getIntent().getExtras().getString("image");
            String movieName=getIntent().getExtras().getString("title");
            String synopsis=getIntent().getExtras().getString("description");
            String dateRel=getIntent().getExtras().getString("date");
            String lang=getIntent().getExtras().getString("langage");

            Glide.with(this).load(img).into(movImage);

            movTitle.setText(movieName);
            descr.setText(synopsis);
            date.setText(dateRel);
            langage.setText(lang);

        }
    }
}
