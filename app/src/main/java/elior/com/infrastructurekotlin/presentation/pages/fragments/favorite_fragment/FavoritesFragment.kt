package elior.com.infrastructurekotlin.presentation.pages.fragments.favorite_fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import elior.com.infrastructurekotlin.FavoritesGraphArgs
import elior.com.infrastructurekotlin.R
import elior.com.infrastructurekotlin.core.Constants.TAG
import elior.com.infrastructurekotlin.databinding.FragmentFavoritesBinding
import elior.com.infrastructurekotlin.presentation.pages.fragments.BaseFragment
import elior.com.infrastructurekotlin.data.managers.ViewModelManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoritesFragment : BaseFragment() {

    private lateinit var binding: FragmentFavoritesBinding
    private val favoritesViewModel = ViewModelManager.instance.favoritesViewModel
    private val eventsViewModelRoom = ViewModelManager.instance.eventsViewModelRoom

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

        lifecycleScope.launch {
            favoritesViewModel.eventsFavoritesAdapter.setData(eventsViewModelRoom.getAll())
        }
    }

}
