package elior.com.infrastructurekotlin.presentation.pages.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import elior.com.infrastructurekotlin.R
import elior.com.infrastructurekotlin.core.Constants
import elior.com.infrastructurekotlin.data.fragstates.MoviesFragState
import elior.com.infrastructurekotlin.databinding.FragmentMainBinding
import elior.com.infrastructurekotlin.presentation.adapters.MoviesMainAdapter
import elior.com.infrastructurekotlin.presentation.pages.viewmodels.MoviesViewModel

class MainFragment : BaseFragment() {

    private lateinit var binding: FragmentMainBinding
    private val moviesViewModel = MoviesViewModel()

    private val mObserver: Observer<MoviesFragState> =
        Observer { moviesFragState: MoviesFragState? ->
            if (moviesFragState != null) {
                if (!moviesFragState.isHasBeenViewed) {
                    if (moviesFragState.isOk) {
                        when (moviesFragState.state) {
                            Constants.MOVIES -> {

                                setData()
                                saveDataToLocalData()
                            }
                        }
                    } else {
                        when (moviesFragState.stateErrorCode) {
                            Constants.RESPONSE_ERROR -> Toast.makeText(
                                activity,
                                activity?.resources?.getString(R.string.response_error),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }

                    hideProgressDialog()

                    moviesFragState.isHasBeenViewed = true
                }
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initDataBinding(inflater, container)
        connectObserverToViewModel()
        callGetAllMoviesEndPoint()

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()

        removeObserverFromViewModel()
    }

    private fun initDataBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.moviesViewModel = moviesViewModel
        binding.lifecycleOwner = this
    }

    private fun connectObserverToViewModel() {
        moviesViewModel.moviesFragStateMutableLiveData.observe(viewLifecycleOwner, mObserver)
    }

    private fun removeObserverFromViewModel() {
        moviesViewModel.moviesFragStateMutableLiveData.removeObserver(mObserver)
    }

    private fun callGetAllMoviesEndPoint() {
        showProgressDialog(requireActivity().resources.getString(R.string.loading_your_data))

        moviesViewModel.getAllMovies()
    }

    private fun setData() {
        moviesViewModel.moviesMainAdapter.setData(moviesViewModel.movieModel!!.results)
    }

    private fun saveDataToLocalData() {
        moviesViewModel.saveDataToLocalData()
    }

}
