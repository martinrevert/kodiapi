/**
 * Created by martin on 29/03/17.
 */

import com.google.gson.Gson;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import models.Movie;

import java.sql.SQLException;
import java.util.List;

import static spark.Spark.*;


public class main {
    private final static String DATABASE_URL = "jdbc:mysql://192.168.1.124:3306/MyVideos107?user=kodi&password=kodi&useSSL=false\n";

    public static void main(String[] args) throws SQLException {

        ConnectionSource connectionSource = new JdbcConnectionSource(DATABASE_URL);

        Dao<Movie, ?> movieDao = DaoManager.createDao(connectionSource, Movie.class);
        List<Movie> movies = movieDao.queryForAll();

        Gson gson = new Gson();

        get("/all", "application/json", (req, res) -> movies, gson::toJson);


    }

}

