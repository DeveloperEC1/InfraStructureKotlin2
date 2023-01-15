package elior.com.infrastructurekotlin.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import elior.com.infrastructurekotlin.R
import elior.com.infrastructurekotlin.databinding.AdapterMoviesFavoritesBinding
import elior.com.infrastructurekotlin.data.room.MoviesRoom
import elior.com.infrastructurekotlin.presentation.adapters.viewholders.MoviesFavoritesViewHolder

class MoviesFavoritesAdapter : RecyclerView.Adapter<MoviesFavoritesViewHolder>() {

    private lateinit var moviesFavoritesArrayList: List<MoviesRoom>

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

    @SuppressLint("NotifyDataSetChanged")
    fun setData(moviesFavoritesArrayList: List<MoviesRoom>) {
        this.moviesFavoritesArrayList = moviesFavoritesArrayList
        notifyDataSetChanged()
    }

}
