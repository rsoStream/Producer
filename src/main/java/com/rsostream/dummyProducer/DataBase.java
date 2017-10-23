package com.rsostream.dummyProducer;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private static List<Movie> movies = new ArrayList<>();

    public static List<Movie> getMovies() {
        return movies;
    }

    public static Movie getMovie(int movieId) {
        for (Movie movie : movies) {
            if (movie.getId() == movieId) {
                return movie;
            }
        }
        return null;
    }

    public static void addMovie(Movie movie) {
        movies.add(movie);
    }

    public static void deleteMovie(int movieId) {
        for (Movie movie : movies) {
            if (movie.getId() == movieId) {
                movies.remove(movie);
                break;
            }
        }
    }

    public static boolean isEmpty() {
        return movies.isEmpty();
    }
}

