package elior.com.infrastructurekotlin.data.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import elior.com.infrastructurekotlin.core.MyApplication.Companion.application

class MoviesViewModelRoom : ViewModel() {

    private val moviesDaoFavorites: MoviesDaoRoom =
        MoviesDatabaseRoom.getDatabase(application).moviesDao()

    fun insert(moviesFavorites: MoviesRoom) = moviesDaoFavorites.insert(moviesFavorites)

    fun update(moviesFavorites: MoviesRoom) = moviesDaoFavorites.update(moviesFavorites)

    fun delete() = moviesDaoFavorites.delete()

    fun deleteAll() = moviesDaoFavorites.deleteAll()

    val getAll: LiveData<List<MoviesRoom>> = moviesDaoFavorites.getAll()

}
