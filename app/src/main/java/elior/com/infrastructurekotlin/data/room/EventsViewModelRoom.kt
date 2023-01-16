package elior.com.infrastructurekotlin.data.room

import androidx.lifecycle.ViewModel
import elior.com.infrastructurekotlin.core.MyApplication.Companion.application

class EventsViewModelRoom : ViewModel() {

    private val eventsDaoFavorites: EventsDaoRoom =
        EventsDatabaseRoom.getDatabase(application).eventsDao()

    fun insert(eventsFavorites: EventsRoom) = eventsDaoFavorites.insert(eventsFavorites)

    fun update(eventsFavorites: EventsRoom) = eventsDaoFavorites.update(eventsFavorites)

    fun delete() = eventsDaoFavorites.delete()

    fun deleteAll() = eventsDaoFavorites.deleteAll()

    fun getAll() = eventsDaoFavorites.getAll()

}
