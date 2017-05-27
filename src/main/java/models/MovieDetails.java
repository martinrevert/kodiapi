package models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by martin on 21/04/17.
 */
@DatabaseTable(tableName = "moviedetails")

public class MovieDetails {

    @DatabaseField
    private int idMovie;
    @DatabaseField //title
    private String c00;
    @DatabaseField //description
    private String c01;
    @DatabaseField //plot
    private String c03;
    @DatabaseField //Guion
    private String c06;
    @DatabaseField //poster
    private String c08;
    @DatabaseField //genero
    private String c14;
    @DatabaseField //director
    private String c15;
    @DatabaseField //estudio
    private String c18;
    @DatabaseField //triler
    private String c19;
    @DatabaseField //imdb
    private String uniqueid_value;
    @DatabaseField
    private String premiered;
    @DatabaseField
    private String rating;
    @DatabaseField
    private String votes;
    @DatabaseField //pais
    private String c21;
    @DatabaseField //fanart
    private String c20;


    MovieDetails(){

    }

}
