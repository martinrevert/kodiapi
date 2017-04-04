package models;


/**
 * Created by martin on 30/03/17.
 */

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "movie")
public class Movie {

    @DatabaseField
    private int idMovie;
    @DatabaseField
    private String c00;
    @DatabaseField
    private String c08;


    Movie() {

    }

    public String getC00() {
        return c00;
    }

    public void setC00(String c00) {
        this.c00 = c00;
    }

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    public String getC08() {
        return c08;
    }

    public void setC08(String c08) {
        this.c08 = c08;
    }
}
