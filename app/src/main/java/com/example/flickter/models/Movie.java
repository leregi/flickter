package com.example.flickter.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;


@Parcel
public class Movie {
    int movieId;
    double getAverage;
    String posterPath;
    String title;
    String overview;
    String backdropPath;

    // Empty constructor needed for the Parceler Library
    public Movie() {
    }

    public  Movie(JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        backdropPath = jsonObject.getString("backdrop_path");
        getAverage = jsonObject.getDouble("vote_average");
        movieId = jsonObject.getInt("id");
    }

    public static List<Movie> fromJsonArray(JSONArray moviejsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();

        for(int i = 0; i < moviejsonArray.length(); i++) {
            movies.add(new Movie(moviejsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public  String  getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);

    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getGetAverage() {
        return getAverage;
    }

    public int getMovieId() {
        return movieId;
    }
}
