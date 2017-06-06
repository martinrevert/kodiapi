package controllers

import com.j256.ormlite.dao.Dao
import com.j256.ormlite.dao.DaoManager
import com.j256.ormlite.dao.GenericRawResults
import com.j256.ormlite.jdbc.JdbcConnectionSource
import com.j256.ormlite.support.ConnectionSource
import models.Movie
import models.MovieDetails

import java.sql.SQLException

/**
 * Created by martin on 02/04/17.
 */
class MoviesController {

    //Todo paginar (offset?)
    val allMovies: List<Movie>?
        get() {
            var connectionSource: ConnectionSource? = null
            try {
                connectionSource = JdbcConnectionSource(DATABASE_URL)
            } catch (e: SQLException) {
                e.printStackTrace()
            }

            var movieDao: Dao<Movie, *>? = null
            try {
                assert(connectionSource != null)
                movieDao = DaoManager.createDao(connectionSource!!, Movie::class.java)
            } catch (e: SQLException) {
                e.printStackTrace()
            }

            var movies: List<Movie>? = null
            try {
                assert(movieDao != null)
                movies = movieDao!!.queryForAll()
            } catch (e: SQLException) {
                e.printStackTrace()
            }

            return movies
        }

    fun getMoviebyId(id: String): MovieDetails? {

        var connectionSource: ConnectionSource? = null
        try {
            connectionSource = JdbcConnectionSource(DATABASE_URL)
        } catch (e: SQLException) {
            e.printStackTrace()
        }

        val query = "SELECT a.idMovie, a.c00,a.c01,a.c03, a.c06, a.c08, a.c14, a.c15, a.c18, a.c19, a.c20, a.c21, a.premiered, b.rating, b.votes, b.uniqueid_value FROM movie AS a " +
                "LEFT JOIN movie_view AS b " +
                "ON a.idMovie = b.idMovie " +
                "WHERE a.idMovie = \"" + id + "\""

        var movie: MovieDetails? = null
        var daoMovieDetails: Dao<MovieDetails, *>? = null
        try {
            assert(connectionSource != null)
            daoMovieDetails = DaoManager.createDao(connectionSource!!, MovieDetails::class.java)
        } catch (e: SQLException) {
            e.printStackTrace()
        }

        var rawResults: GenericRawResults<MovieDetails>? = null
        try {
            if (daoMovieDetails != null) {
                rawResults = daoMovieDetails.queryRaw(query, daoMovieDetails.rawRowMapper)
            }
        } catch (e: SQLException) {
            e.printStackTrace()
        }

        try {
            if (rawResults != null) {
                movie = rawResults.firstResult
            }
        } catch (e: SQLException) {
            e.printStackTrace()
        }

        return movie
    }

    companion object {


        private val DATABASE_URL = "jdbc:mysql://192.168.1.124:3306/MyVideos107?user=kodi&password=kodi&useSSL=false\n"
    }

}
