package models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by martin on 30/03/17.
 */
@DatabaseTable(tableName = "movie")
public class Movie {

    @DatabaseField
    private int idMovie;
    @DatabaseField
    private String c00;
    @DatabaseField
    private String c01;
    @DatabaseField
    private String c19;
    @DatabaseField
    private String c14;
    @DatabaseField
    private String c15;
    @DatabaseField
    private String c20;
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

    public String getC01() {
        return c01;
    }

    public void setC01(String c01) {
        this.c01 = c01;
    }

    public String getC19() {
        return c19;
    }

    public void setC19(String c19) {
        this.c19 = c19;
    }

    public String getC14() {
        return c14;
    }

    public void setC14(String c14) {
        this.c14 = c14;
    }

    public String getC15() {
        return c15;
    }

    public void setC15(String c15) {
        this.c15 = c15;
    }

    public String getC20() {
        return c20;
    }

    public void setC20(String c20) {
        this.c20 = c20;
    }

    public String getC08() {
        return c08;
    }

    public void setC08(String c08) {
        this.c08 = c08;
    }
}
