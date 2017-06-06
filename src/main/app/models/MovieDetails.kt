package models

import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable

/**
 * Created by martin on 21/04/17.
 */
@DatabaseTable(tableName = "moviedetails")
class MovieDetails internal constructor() {

    @DatabaseField
    private val idMovie: Int = 0
    @DatabaseField //title
    private val c00: String? = null
    @DatabaseField //description
    private val c01: String? = null
    @DatabaseField //plot
    private val c03: String? = null
    @DatabaseField //Guion
    private val c06: String? = null
    @DatabaseField //poster
    private val c08: String? = null
    @DatabaseField //genero
    private val c14: String? = null
    @DatabaseField //director
    private val c15: String? = null
    @DatabaseField //estudio
    private val c18: String? = null
    @DatabaseField //triler
    private val c19: String? = null
    @DatabaseField //imdb
    private val uniqueid_value: String? = null
    @DatabaseField
    private val premiered: String? = null
    @DatabaseField
    private val rating: String? = null
    @DatabaseField
    private val votes: String? = null
    @DatabaseField //pais
    private val c21: String? = null
    @DatabaseField //fanart
    private val c20: String? = null

}
