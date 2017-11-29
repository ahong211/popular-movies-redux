package com.example.android.popularmovies;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.popularmovies.model.MovieInfo;
import com.example.android.popularmovies.utils.MovieJsonUtils;
import com.example.android.popularmovies.utils.NetworkUtils;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;

public class MovieLandingPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_landing_page);
    }

    public class FetchMovieTask extends AsyncTask<String, Void, MovieInfo[]> {

        @Override
        protected MovieInfo[] doInBackground(String... strings) {

            URL movieUrl = NetworkUtils.buildUrl(strings[0]);

            try {
                String movieStrResponse = NetworkUtils.getResponseFromHttpUrl(movieUrl);
                MovieInfo[] movieData = MovieJsonUtils.getMovieJson(MovieLandingPageActivity.this, movieStrResponse);

                return movieData;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(MovieInfo[] movieInfos) {
            super.onPostExecute(movieInfos);

            
        }
    }
}
