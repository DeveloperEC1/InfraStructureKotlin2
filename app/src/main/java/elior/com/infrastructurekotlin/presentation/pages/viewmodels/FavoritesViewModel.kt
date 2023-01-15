package elior.com.infrastructurekotlin.presentation.pages.viewmodels

import androidx.lifecycle.ViewModel
import elior.com.infrastructurekotlin.presentation.adapters.MoviesFavoritesAdapter

class FavoritesViewModel : ViewModel() {

    val moviesFavoritesAdapter: MoviesFavoritesAdapter = MoviesFavoritesAdapter()

}
