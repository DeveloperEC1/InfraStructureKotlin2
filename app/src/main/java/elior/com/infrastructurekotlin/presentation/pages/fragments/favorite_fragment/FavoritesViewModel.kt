package elior.com.infrastructurekotlin.presentation.pages.fragments.favorite_fragment

import androidx.lifecycle.ViewModel
import elior.com.infrastructurekotlin.presentation.adapters.EventsFavoritesAdapter

class FavoritesViewModel : ViewModel() {

    val eventsFavoritesAdapter: EventsFavoritesAdapter = EventsFavoritesAdapter()

}
