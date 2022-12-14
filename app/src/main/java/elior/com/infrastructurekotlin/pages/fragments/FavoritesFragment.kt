package elior.com.infrastructurekotlin.pages.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import elior.com.infrastructurekotlin.FavoritesGraphArgs
import elior.com.infrastructurekotlin.R
import elior.com.infrastructurekotlin.adapters.MoviesFavoritesAdapter
import elior.com.infrastructurekotlin.databinding.FragmentFavoritesBinding
import elior.com.infrastructurekotlin.room.MoviesViewModelFavorites

class FavoritesFragment : BaseFragment() {

    private lateinit var binding: FragmentFavoritesBinding
    private lateinit var moviesViewModelFavorites: MoviesViewModelFavorites

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorites, container, false)

        initUI()
        setData()

        return binding.root
    }

    private fun initUI() {
        moviesViewModelFavorites = ViewModelProvider(this)[MoviesViewModelFavorites::class.java]
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
