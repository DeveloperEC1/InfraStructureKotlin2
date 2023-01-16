package elior.com.infrastructurekotlin.presentation.pages.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import elior.com.infrastructurekotlin.FavoritesGraphArgs
import elior.com.infrastructurekotlin.R
import elior.com.infrastructurekotlin.core.Constants.TAG
import elior.com.infrastructurekotlin.data.room.EventsViewModelRoom
import elior.com.infrastructurekotlin.databinding.FragmentFavoritesBinding
import elior.com.infrastructurekotlin.presentation.pages.viewmodels.FavoritesViewModel

class FavoritesFragment : BaseFragment() {

    private lateinit var binding: FragmentFavoritesBinding
    private val eventsViewModelFavorites: EventsViewModelRoom = EventsViewModelRoom()
    private val favoritesViewModel: FavoritesViewModel = FavoritesViewModel()

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
        binding.favoritesViewModel = favoritesViewModel
        binding.lifecycleOwner = this
    }

    private fun setData() {
        Log.i(TAG, FavoritesGraphArgs.fromBundle(requireArguments()).eventsData.activity!!)
//        Log.i(TAG, (requireArguments().getSerializable("eventsData") as Events).activity!!)

        eventsViewModelFavorites.getAll().observe(viewLifecycleOwner) { eventsFavorites ->
            eventsFavorites?.let {
                favoritesViewModel.eventsFavoritesAdapter.setData(it)
            }
        }
    }

}
