package elior.com.infrastructurekotlin.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MoviesFavorites::class], version = 3, exportSchema = false)
abstract class MoviesRoomDatabaseFavorites : RoomDatabase() {

    abstract fun moviesDao(): MoviesDaoFavorites

    companion object {
        @Volatile
        private var INSTANCE: MoviesRoomDatabaseFavorites? = null

        fun getDatabase(context: Context): MoviesRoomDatabaseFavorites {
            return INSTANCE
                ?: synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        MoviesRoomDatabaseFavorites::class.java,
                        "movies_table_favorites"
                    )
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                    INSTANCE = instance
                    instance
                }
        }
    }

}
