package elior.com.infrastructurekotlin.data.managers

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import elior.com.infrastructurekotlin.data.room.EventsViewModelRoom
import elior.com.infrastructurekotlin.presentation.pages.fragments.events_fragment.EventsViewModel
import elior.com.infrastructurekotlin.presentation.pages.fragments.favorite_fragment.FavoritesViewModel

class ViewModelManager {

    lateinit var eventsViewModelRoom: EventsViewModelRoom
    lateinit var eventsViewModel: EventsViewModel
    lateinit var favoritesViewModel: FavoritesViewModel

    fun initViewModels(activity: FragmentActivity) {
        eventsViewModelRoom = ViewModelProvider(activity)[EventsViewModelRoom::class.java]
        eventsViewModel = ViewModelProvider(activity)[EventsViewModel::class.java]
        favoritesViewModel = ViewModelProvider(activity)[FavoritesViewModel::class.java]
    }

    companion object {
        val instance = ViewModelManager()

    }

}