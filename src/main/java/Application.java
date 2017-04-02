/**
 * Created by martin on 29/03/17.
 */

import com.google.gson.Gson;

import controllers.MoviesController;

import spark.servlet.SparkApplication;
import static spark.Spark.*;


public class Application implements SparkApplication {
    private Gson gson = new Gson();

    @Override
    public void init() {
        MoviesController moviescontroller = new MoviesController();

        get("/movies", "application/json", (req, res) -> moviescontroller.getAllMovies(), gson::toJson);

        get("/", (req,res)-> "Kodi API root");

    }
}

