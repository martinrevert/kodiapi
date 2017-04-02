package controllers;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import models.Movie;

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

        return movies;
    }

}
