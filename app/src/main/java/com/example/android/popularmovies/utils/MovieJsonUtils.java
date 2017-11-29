package com.example.android.popularmovies.utils;

import android.content.Context;

import com.example.android.popularmovies.model.MovieInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Albert on 11/28/17.
 */

public class MovieJsonUtils {
    public static MovieInfo[] getMovieJson(Context context, String movieStr) throws JSONException {

        final String MDB_RESULTS = "results";
        final String MDB_ORIGINAL_TITLE = "original_title";
        final String MDB_POSTER_PATH = "poster_path";
        final String MDB_OVERVIEW = "overview";
        final String MDB_VOTE_AVERAGE = "vote_average";
        final String MDB_RELEASE_DATE = "release_date";

        String posterPathString;
        String originalTitleString;
        String overviewString;
        String voteAverageString;
        double releaseDateString;

        MovieInfo[] parsedMovieData = null;

        JSONObject movieJson = new JSONObject(movieStr);

        JSONArray movieArray = movieJson.getJSONArray(MDB_RESULTS);

        parsedMovieData = new MovieInfo[movieArray.length()];

        for (int i = 0; i < movieArray.length(); i++) {
            JSONObject movieJsonObject = movieArray.getJSONObject(i);

            originalTitleString = movieJsonObject.getString(MDB_ORIGINAL_TITLE);
            posterPathString = movieJsonObject.getString(MDB_POSTER_PATH);
            overviewString = movieJsonObject.getString(MDB_OVERVIEW);
            voteAverageString = movieJsonObject.getString(MDB_VOTE_AVERAGE);
            releaseDateString = movieJsonObject.getDouble(MDB_RELEASE_DATE);

            parsedMovieData[i] = new MovieInfo(originalTitleString, posterPathString, overviewString,
                    voteAverageString, releaseDateString);
        }

        return parsedMovieData;
    }
}
