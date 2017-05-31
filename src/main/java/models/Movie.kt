package models


/**
 * Created by martin on 30/03/17.
 */

import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable

@DatabaseTable(tableName = "movie")
class Movie internal constructor() {

    @DatabaseField
    var idMovie: Int = 0
    @DatabaseField
    var c00: String? = null
    @DatabaseField
    var c08: String? = null
}
