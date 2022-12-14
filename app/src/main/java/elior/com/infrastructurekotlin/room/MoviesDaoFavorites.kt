package elior.com.infrastructurekotlin.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MoviesDaoFavorites {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(moviesFavorites: MoviesFavorites)

    @Update
    fun update(moviesFavorites: MoviesFavorites)

    @Query("DELETE From movies_table_favorites where ID = ID")
    fun delete()

    @Query("DELETE FROM movies_table_favorites")
    fun deleteAll()

    @Query("SELECT * from movies_table_favorites")
    fun getAll(): LiveData<List<MoviesFavorites>>

}
