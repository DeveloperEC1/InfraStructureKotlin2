package elior.com.infrastructurekotlin.retrofit

import elior.com.infrastructurekotlin.models.MovieModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface GetDataService {

    @GET
    fun getAllMovies(@Url url: String): Call<MovieModel>

}
