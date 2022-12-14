package elior.com.infrastructurekotlin.data.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MoviesDaoRoom {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(moviesFavorites: MoviesRoom)

    @Update
    fun update(moviesFavorites: MoviesRoom)

    @Query("DELETE From movies_table_favorites where ID = ID")
    fun delete()

    @Query("DELETE FROM movies_table_favorites")
    fun deleteAll()

    @Query("SELECT * from movies_table_favorites")
    fun getAll(): LiveData<List<MoviesRoom>>

}
