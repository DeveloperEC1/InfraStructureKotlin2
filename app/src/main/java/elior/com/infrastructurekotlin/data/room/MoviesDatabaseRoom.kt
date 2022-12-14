package elior.com.infrastructurekotlin.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MoviesRoom::class], version = 3, exportSchema = false)
abstract class MoviesDatabaseRoom : RoomDatabase() {

    abstract fun moviesDao(): MoviesDaoRoom

    companion object {
        @Volatile
        private var INSTANCE: MoviesDatabaseRoom? = null

        fun getDatabase(context: Context): MoviesDatabaseRoom {
            return INSTANCE
                ?: synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        MoviesDatabaseRoom::class.java,
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
