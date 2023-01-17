package elior.com.infrastructurekotlin.data.room

import androidx.lifecycle.ViewModel
import elior.com.infrastructurekotlin.core.MyApplication.Companion.application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EventsViewModelRoom : ViewModel() {

    private val eventsDaoFavorites: EventsDaoRoom =
        EventsDatabaseRoom.getDatabase(application).eventsDao()

    fun insert(eventsFavorites: EventsRoom) {
        CoroutineScope(Dispatchers.IO).launch {
            eventsDaoFavorites.insert(eventsFavorites)
        }
    }

    fun update(eventsFavorites: EventsRoom) {
        CoroutineScope(Dispatchers.IO).launch {
            eventsDaoFavorites.update(eventsFavorites)
        }
    }

    fun delete() {
        CoroutineScope(Dispatchers.IO).launch {
            eventsDaoFavorites.delete()
        }
    }

    fun deleteAll() {
        CoroutineScope(Dispatchers.IO).launch {
            eventsDaoFavorites.deleteAll()
        }
    }

    suspend fun getAll() = eventsDaoFavorites.getAll()

}
