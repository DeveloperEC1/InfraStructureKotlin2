package elior.com.infrastructurekotlin.presentation.pages.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import elior.com.infrastructurekotlin.FavoritesGraphArgs
import elior.com.infrastructurekotlin.R
import elior.com.infrastructurekotlin.data.room.MoviesViewModelRoom
import elior.com.infrastructurekotlin.databinding.FragmentFavoritesBinding
import elior.com.infrastructurekotlin.presentation.adapters.MoviesFavoritesAdapter

class FavoritesFragment : BaseFragment() {

    private lateinit var binding: FragmentFavoritesBinding
    private var moviesViewModelFavorites: MoviesViewModelRoom = MoviesViewModelRoom()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initDataBinding(inflater, container)
        setData()

        return binding.root
    }

    private fun initDataBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorites, container, false)
    }

    private fun setData() {
        Log.i("getData1", FavoritesGraphArgs.fromBundle(requireArguments()).resultsData.title!!)
//        Log.i("getData1", (requireArguments().getSerializable("resultsData") as Results).title!!)

        moviesViewModelFavorites.getAll.observe(viewLifecycleOwner) { moviesFavorites ->
            moviesFavorites?.let {
                binding.recyclerView.adapter = MoviesFavoritesAdapter(it)
            }
        }
    }

}
