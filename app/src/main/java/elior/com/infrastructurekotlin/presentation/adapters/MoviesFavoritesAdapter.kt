package elior.com.infrastructurekotlin.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import elior.com.infrastructurekotlin.R
import elior.com.infrastructurekotlin.databinding.AdapterMoviesFavoritesBinding
import elior.com.infrastructurekotlin.data.room.MoviesRoom
import elior.com.infrastructurekotlin.presentation.adapters.viewholders.MoviesFavoritesViewHolder

class MoviesFavoritesAdapter internal constructor(
    private var moviesFavoritesArrayList: List<MoviesRoom>
) :
    RecyclerView.Adapter<MoviesFavoritesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesFavoritesViewHolder {
        val binding: AdapterMoviesFavoritesBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.adapter_movies_favorites,
            parent,
            false
        )
        return MoviesFavoritesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesFavoritesViewHolder, position: Int) {
        val movieFavorites: MoviesRoom = moviesFavoritesArrayList[position]

        holder.binding.movieFavorites = movieFavorites
    }

    override fun getItemCount() = moviesFavoritesArrayList.size

}
