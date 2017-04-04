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

    public Object getAllDataFromAllMovies(){
    return null;
    }

    public Movie getMoviebyId(){
    return null;
    }

}
/*
EJEMPLO QUERY RAW

      String query = "SELECT ifnull(b.bonific, 0) AS bonif, a.codigo, a.descripcion, a.emp, a.existencia, a.factor, a.grupo, " +
                                "a.iva, a.medida1, a.medida2,a.preneto, a.tipo_precio, a.uventa, a.peso FROM producto AS a LEFT JOIN bonificacion AS b ON a.grupo = b.grupo" +
                                " AND b.cliente = \"" + cliente + "\" WHERE a.grupo = \"" + d + "\"";


  GenericRawResults<Producto> rawResults = daoproducto.queryRaw(query, daoproducto.getRawRowMapper());
            List<Producto> productosdblocal = rawResults.getResults();



 */