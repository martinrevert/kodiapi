package models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by martin on 30/03/17.
 */
@DatabaseTable(tableName = "movie")
public class Movie {

    @DatabaseField
    private String c00;

    Movie(){

    }

    public String getC00() {
        return c00;
    }

    public void setC00(String c00) {
        this.c00 = c00;
    }
}
