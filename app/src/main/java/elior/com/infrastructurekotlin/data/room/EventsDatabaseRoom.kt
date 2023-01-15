package elior.com.infrastructurekotlin.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [EventsRoom::class], version = 3, exportSchema = false)
abstract class EventsDatabaseRoom : RoomDatabase() {

    abstract fun eventsDao(): EventsDaoRoom

    companion object {
        @Volatile
        private var INSTANCE: EventsDatabaseRoom? = null

        fun getDatabase(context: Context): EventsDatabaseRoom {
            return INSTANCE
                ?: synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        EventsDatabaseRoom::class.java,
                        "events_table_favorites"
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
