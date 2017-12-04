package com.example.android.popularmovies;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.popularmovies.model.MovieInfo;

/**
 * Created by Albert on 12/4/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder>{
    MovieInfo[] movies;

    public MovieAdapter(MovieInfo[] movies) {
        this.movies = movies;
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item_holder, parent, false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {
        String title = movies[position].getOriginalTitle();
        holder.movieTitle.setText(title);
    }

    @Override
    public int getItemCount() {
        return movies.length;
    }

    public class MovieHolder extends RecyclerView.ViewHolder {
        TextView movieTitle;

        public MovieHolder(View itemView) {
            super(itemView);
            movieTitle = itemView.findViewById(R.id.tv_item_holder);
        }
    }
}
