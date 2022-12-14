package elior.com.infrastructurekotlin.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import elior.com.infrastructurekotlin.others.MyApplication.Companion.application

class MoviesViewModelFavorites : ViewModel() {

    private val moviesDaoFavorites: MoviesDaoFavorites =
        MoviesRoomDatabaseFavorites.getDatabase(application).moviesDao()

    fun insert(moviesFavorites: MoviesFavorites) = moviesDaoFavorites.insert(moviesFavorites)

    fun update(moviesFavorites: MoviesFavorites) = moviesDaoFavorites.update(moviesFavorites)

    fun delete() = moviesDaoFavorites.delete()

    fun deleteAll() = moviesDaoFavorites.deleteAll()

    val getAll: LiveData<List<MoviesFavorites>> = moviesDaoFavorites.getAll()

}
