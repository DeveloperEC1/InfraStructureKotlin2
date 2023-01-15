package elior.com.infrastructurekotlin.presentation.pages.viewmodels

import androidx.lifecycle.ViewModel
import elior.com.infrastructurekotlin.presentation.adapters.EventsFavoritesAdapter

class FavoritesViewModel : ViewModel() {

    val eventsFavoritesAdapter: EventsFavoritesAdapter = EventsFavoritesAdapter()

}
