/**
 * Created by martin on 29/03/17.
 */

import com.google.gson.Gson;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import models.Movie;
import spark.servlet.SparkApplication;

import java.sql.SQLException;
import java.util.List;

import static spark.Spark.*;


public class Application implements SparkApplication {
    private final static String DATABASE_URL = "jdbc:mysql://192.168.1.124:3306/MyVideos107?user=kodi&password=kodi&useSSL=false\n";

    @Override
    public void init() {

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

        Gson gson = new Gson();

        List<Movie> finalMovies = movies;
        get("/movies", "application/json", (req, res) -> finalMovies, gson::toJson);

    }
}

