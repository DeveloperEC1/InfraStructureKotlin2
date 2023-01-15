package elior.com.infrastructurekotlin.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "events_table_favorites",
    indices = [Index(value = ["activity"], unique = true)]
)

class EventsRoom {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    var ID: Long = 0

    @ColumnInfo(name = "activity")
    var activity: String = ""

}
