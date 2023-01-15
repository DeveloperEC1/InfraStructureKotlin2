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
import elior.com.infrastructurekotlin.data.fragstates.EventsFragState
import elior.com.infrastructurekotlin.databinding.FragmentMainBinding
import elior.com.infrastructurekotlin.presentation.pages.viewmodels.EventsViewModel

class MainFragment : BaseFragment() {

    private lateinit var binding: FragmentMainBinding
    private val eventsViewModel = EventsViewModel()

    private val mObserver: Observer<EventsFragState> =
        Observer { eventsFragState: EventsFragState? ->
            if (eventsFragState != null) {
                if (!eventsFragState.isHasBeenViewed) {
                    if (eventsFragState.isOk) {
                        when (eventsFragState.state) {
                            Constants.EVENTS -> {

                                setData()
                                saveDataToLocalData()
                            }
                        }
                    } else {
                        when (eventsFragState.stateErrorCode) {
                            Constants.RESPONSE_ERROR -> Toast.makeText(
                                activity,
                                activity?.resources?.getString(R.string.response_error),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }

                    hideProgressDialog()

                    eventsFragState.isHasBeenViewed = true
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
        callGetAllActivitiesEndPoint()

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()

        removeObserverFromViewModel()
    }

    private fun initDataBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.eventsViewModel = eventsViewModel
        binding.lifecycleOwner = this
    }

    private fun connectObserverToViewModel() {
        eventsViewModel.eventsFragStateMutableLiveData.observe(viewLifecycleOwner, mObserver)
    }

    private fun removeObserverFromViewModel() {
        eventsViewModel.eventsFragStateMutableLiveData.removeObserver(mObserver)
    }

    private fun callGetAllActivitiesEndPoint() {
        showProgressDialog(requireActivity().resources.getString(R.string.loading_your_data))

        eventsViewModel.getAllActivities()
    }

    private fun setData() {
        eventsViewModel.eventsMainAdapter.setData(eventsViewModel.getDummyData())
    }

    private fun saveDataToLocalData() {
        eventsViewModel.saveDataToLocalData()
    }

}
