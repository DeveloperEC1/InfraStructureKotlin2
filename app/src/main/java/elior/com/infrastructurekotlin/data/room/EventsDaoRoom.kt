package elior.com.infrastructurekotlin.data.room

import androidx.room.*

@Dao
interface EventsDaoRoom {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(eventsFavorites: EventsRoom)

    @Update
    suspend fun update(eventsFavorites: EventsRoom)

    @Query("DELETE From events_table_favorites where ID = ID")
    suspend fun delete()

    @Query("DELETE FROM events_table_favorites")
    suspend fun deleteAll()

    @Query("SELECT * from events_table_favorites")
    suspend fun getAll(): List<EventsRoom>

}
