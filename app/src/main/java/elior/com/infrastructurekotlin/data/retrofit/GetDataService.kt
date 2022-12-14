package elior.com.infrastructurekotlin.data.retrofit

import elior.com.infrastructurekotlin.data.models.MovieModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface GetDataService {

    @GET
    fun getAllMovies(@Url url: String): Call<MovieModel>

}
