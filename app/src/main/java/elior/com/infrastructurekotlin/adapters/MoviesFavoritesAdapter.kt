package elior.com.infrastructurekotlin.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import elior.com.infrastructurekotlin.R
import elior.com.infrastructurekotlin.databinding.AdapterMoviesFavoritesBinding
import elior.com.infrastructurekotlin.room.MoviesFavorites

class MoviesFavoritesAdapter internal constructor(
    private var moviesFavoritesArrayList: List<MoviesFavorites>
) :
    RecyclerView.Adapter<ViewHolderFavorites>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderFavorites {
        val binding: AdapterMoviesFavoritesBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.adapter_movies_favorites,
            parent,
            false
        )
        return ViewHolderFavorites(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderFavorites, position: Int) {
        val movieFavorites: MoviesFavorites = moviesFavoritesArrayList[position]

        holder.binding.movieFavorites = movieFavorites
    }

    override fun getItemCount() = moviesFavoritesArrayList.size

}
