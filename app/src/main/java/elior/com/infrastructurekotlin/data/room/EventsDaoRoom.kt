package elior.com.infrastructurekotlin.data.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface EventsDaoRoom {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(eventsFavorites: EventsRoom)

    @Update
    fun update(eventsFavorites: EventsRoom)

    @Query("DELETE From events_table_favorites where ID = ID")
    fun delete()

    @Query("DELETE FROM events_table_favorites")
    fun deleteAll()

    @Query("SELECT * from events_table_favorites")
    fun getAll(): LiveData<List<EventsRoom>>

}
