/**
 * Created by martin on 29/03/17.
 */

import com.google.gson.Gson

import controllers.MoviesController
import controllers.MusicController

import spark.servlet.SparkApplication
import spark.Spark.*


class Application : SparkApplication {
    private val gson = Gson()

    override fun init() {
        val moviescontroller = MoviesController()
        val musiccontroller = MusicController()

        get("/") { req, res -> "Kodi API root" }

        get("/movies", "application/json", { req, res -> moviescontroller.allMovies}, gson::toJson)

        get("/movies/:id", "application/json", { req, res -> moviescontroller.getMoviebyId(req.params(":id"))}, gson::toJson)
    }
}

