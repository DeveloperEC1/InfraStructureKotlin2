package elior.com.infrastructurekotlin.presentation.pages.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import elior.com.infrastructurekotlin.core.Constants
import elior.com.infrastructurekotlin.data.fragstates.EventsFragState
import elior.com.infrastructurekotlin.data.models.Events
import elior.com.infrastructurekotlin.data.retrofit.RetrofitClientInstance.Companion.getRetrofitClientInstance
import elior.com.infrastructurekotlin.data.room.EventsRoom
import elior.com.infrastructurekotlin.data.room.EventsViewModelRoom
import elior.com.infrastructurekotlin.presentation.adapters.EventsMainAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventsViewModel : ViewModel() {

    val eventsFragStateMutableLiveData = MutableLiveData<EventsFragState>()
    val text = MutableLiveData<String>()
    val eventsMainAdapter = EventsMainAdapter()
    var events = Events()

    fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        text.value = s.toString()
    }

    fun getAllActivities() {
        getRetrofitClientInstance()!!.getAllActivities("activity")!!
            .enqueue(object : Callback<Events?> {
                override fun onResponse(call: Call<Events?>, response: Response<Events?>) {
                    events = response.body()!!
                    eventsMainAdapter.setData(getDummyData())
                    saveDataToLocalData()

                    postPositiveResponse(Constants.EVENTS)
                }

                override fun onFailure(call: Call<Events?>, t: Throwable) {
                    postNegativeResponse(Constants.RESPONSE_ERROR, Constants.API_ERROR)
                }
            })
    }

    fun saveDataToLocalData() {
        val eventsFavorites = EventsRoom()
        val eventsViewModelFavorites = EventsViewModelRoom()

        for (event in getDummyData()) {
            eventsFavorites.activity = event.activity!!

            eventsViewModelFavorites.insert(eventsFavorites)
        }
    }

    fun getDummyData(): ArrayList<Events> {
        val eventsArrayList = ArrayList<Events>()

//        val events = Events()
//        events.activity = "Elior"

        eventsArrayList.add(events)

        return eventsArrayList
    }

    fun postPositiveResponse(state: String?) {
        val fragState = EventsFragState()
        fragState.state = state
        fragState.isOk = true
        fragState.showWait = false
        eventsFragStateMutableLiveData.postValue(fragState)
    }

    fun postNegativeResponse(errorCode: Int, errorMsg: String?) {
        val fragState = EventsFragState()
        fragState.state = Constants.API_ERROR
        fragState.isOk = false
        fragState.stateErrorCode = errorCode
        fragState.errorMsg = errorMsg
        fragState.showWait = false
        eventsFragStateMutableLiveData.postValue(fragState)
    }

}
