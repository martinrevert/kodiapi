package models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by martin on 21/04/17.
 */
@DatabaseTable(tableName = "movie")

public class MovieDetails {

    @DatabaseField
    private int idMovie;
    @DatabaseField
    private String c00;
    @DatabaseField
    private String c08;
    @DatabaseField
    private String uniqueid_value;

    MovieDetails(){

    }

}
