package elior.com.infrastructurekotlin.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "movies_table_favorites", indices = [Index(value = ["title"], unique = true)])

class MoviesFavorites {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    var ID: Long = 0

    @ColumnInfo(name = "title")
    var title: String = ""

    @ColumnInfo(name = "overview")
    var overview: String = ""

    @ColumnInfo(name = "poster_path")
    var posterPath: String = ""

}
