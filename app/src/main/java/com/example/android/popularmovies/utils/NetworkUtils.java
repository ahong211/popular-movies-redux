package com.example.android.popularmovies.utils;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Albert on 11/23/17.
 */

public class NetworkUtils {
    final static String MOVIE_BASE_URL = "http://api.themoviedb.org/3/movie/";
    final static String MOVIE_POPULAR = "popular";
    final static String MOVIE_TOP_RATED = "top_rated";
    final static String API_KEY = "api_key";


    public static URL buildUrl(String movieType) {
        Uri builtUri = Uri.parse(MOVIE_BASE_URL).buildUpon()
                .appendPath(MOVIE_POPULAR)
                .appendQueryParameter(API_KEY, "e2c8b00f9b43ebe15d40d1517f611e56")
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        InputStream in = urlConnection.getInputStream();

        Scanner scanner = new Scanner(in);
        scanner.useDelimiter("\\A");

        try {
            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}
