package com.example.movieapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieapp.DetailsActivity;
import com.example.movieapp.Model.Genre;
import com.example.movieapp.Model.Movie;
import com.example.movieapp.R;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private Context mContext;
    public static List<Movie> mMovies;
    public static ArrayList<Genre> mGenres;

    public MoviesAdapter(List<Movie> mMovies, ArrayList<Genre> genres)
    {
        this.mMovies=mMovies;
        this.mGenres= genres;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context= parent.getContext();
        mContext=parent.getContext();
        LayoutInflater inflater= LayoutInflater.from(context);
        View mView = inflater.inflate(R.layout.movieitem,parent, false);
        return new MyViewHolder(mView);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {


        myViewHolder.mTitle.setText(mMovies.get(i).getTitle());
        Glide.with(mContext)
                .load(mMovies.get(i).getPosterPath())
                .into(myViewHolder.mImage);


    }

    @Override
    public int getItemCount()
    {
        return mMovies.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ArrayList<String> movieGenres = new ArrayList<String>();
        private TextView mTitle;
        private ImageView mImage;


        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            mTitle = itemView.findViewById(R.id.title);
            mImage = itemView.findViewById(R.id.imgMovie);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos=getAdapterPosition();
                    Movie clickedItem=mMovies.get(pos);
                    movieGenres.clear();
                    for(int i=0; i<mGenres.size(); i++){
                        for(int j=0; j<clickedItem.getGenre_ids().size(); j++){
                            if(clickedItem.getGenre_ids().get(j) == mGenres.get(i).getId())
                                movieGenres.add(mGenres.get(i).getName());
                        }
                    }

                    Intent intent=new Intent(mContext, DetailsActivity.class);
                    intent.putExtra("image",clickedItem.getPosterPath());
                    intent.putExtra("title",clickedItem.getTitle());
                    intent.putExtra("date",clickedItem.getRelease_date());
                    intent.putExtra("description",clickedItem.getOverview());
                    intent.putExtra("langage",clickedItem.getOriginal_language());
                    intent.putExtra("genres", movieGenres);

                    mContext.startActivity(intent);
                }
            });



        }
    }

}
