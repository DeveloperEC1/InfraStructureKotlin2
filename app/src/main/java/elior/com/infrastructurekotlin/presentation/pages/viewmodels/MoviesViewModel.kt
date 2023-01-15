package elior.com.infrastructurekotlin.presentation.pages.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import elior.com.infrastructurekotlin.data.fragstates.MoviesFragState
import elior.com.infrastructurekotlin.data.models.MovieModel
import elior.com.infrastructurekotlin.core.Constants
import elior.com.infrastructurekotlin.data.retrofit.RetrofitClientInstance.Companion.getRetrofitClientInstance
import elior.com.infrastructurekotlin.data.room.MoviesRoom
import elior.com.infrastructurekotlin.data.room.MoviesViewModelRoom
import elior.com.infrastructurekotlin.presentation.adapters.MoviesMainAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesViewModel : ViewModel() {

    var movieModel: MovieModel? = null
    val moviesFragStateMutableLiveData: MutableLiveData<MoviesFragState> = MutableLiveData()
    val text = MutableLiveData<String>()
    val moviesMainAdapter: MoviesMainAdapter = MoviesMainAdapter()

    fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        text.value = s.toString()
    }

    fun getAllMovies() {
        getRetrofitClientInstance()!!.getAllMovies("/3/search/movie?/&query=q&api_key=" + Constants.API_KEY)
            .enqueue(object : Callback<MovieModel?> {
                override fun onResponse(call: Call<MovieModel?>, response: Response<MovieModel?>) {
                    movieModel = response.body()

                    postPositiveResponse(Constants.MOVIES)
                }

                override fun onFailure(call: Call<MovieModel?>, t: Throwable) {
                    postNegativeResponse(Constants.RESPONSE_ERROR, Constants.API_ERROR)
                }
            })
    }

    fun saveDataToLocalData() {
        val moviesViewModelFavorites = MoviesViewModelRoom()
        val moviesFavorites = MoviesRoom()

        for (result in movieModel!!.results) {
            moviesFavorites.title = result.title!!

            moviesViewModelFavorites.insert(moviesFavorites)
        }
    }

    fun postPositiveResponse(state: String?) {
        val fragState = MoviesFragState()
        fragState.state = state
        fragState.isOk = true
        fragState.showWait = false
        moviesFragStateMutableLiveData.postValue(fragState)
    }

    fun postNegativeResponse(errorCode: Int, errorMsg: String?) {
        val fragState = MoviesFragState()
        fragState.state = Constants.API_ERROR
        fragState.isOk = false
        fragState.stateErrorCode = errorCode
        fragState.errorMsg = errorMsg
        fragState.showWait = false
        moviesFragStateMutableLiveData.postValue(fragState)
    }

}
