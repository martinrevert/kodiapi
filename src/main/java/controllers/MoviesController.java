package controllers;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import models.Movie;
import models.MovieDetails;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by martin on 02/04/17.
 */
public class MoviesController {


    private final static String DATABASE_URL = "jdbc:mysql://192.168.1.124:3306/MyVideos107?user=kodi&password=kodi&useSSL=false\n";

    public List<Movie> getAllMovies() {
        ConnectionSource connectionSource = null;
        try {
            connectionSource = new JdbcConnectionSource(DATABASE_URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Dao<Movie, ?> movieDao = null;
        try {
            assert connectionSource != null;
            movieDao = DaoManager.createDao(connectionSource, Movie.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Movie> movies = null;
        try {
            assert movieDao != null;
            movies = movieDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Todo paginar (offset?)
        return movies;
    }

    public MovieDetails getMoviebyId(String id) {

        ConnectionSource connectionSource = null;
        try {
            connectionSource = new JdbcConnectionSource(DATABASE_URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "SELECT a.idMovie, a.c00,a.c01,a.c03, a.c06, a.c08, a.c14, a.c15, a.c18, a.c19, a.c20, a.c21, a.premiered, b.rating, b.votes, b.uniqueid_value FROM movie AS a " +
                "LEFT JOIN movie_view AS b " +
                "ON a.idMovie = b.idMovie " +
                "WHERE a.idMovie = \"" + id + "\"";

        MovieDetails movie = null;
        Dao<MovieDetails, ?> daoMovieDetails = null;
        try {
            assert connectionSource != null;
            daoMovieDetails = DaoManager.createDao(connectionSource, MovieDetails.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        GenericRawResults<MovieDetails> rawResults = null;
        try {
            if (daoMovieDetails != null) {
                rawResults = daoMovieDetails.queryRaw(query, daoMovieDetails.getRawRowMapper());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rawResults != null) {
                movie = rawResults.getFirstResult();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movie;
    }

}
