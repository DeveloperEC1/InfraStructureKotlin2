package elior.com.infrastructurekotlin.data.retrofit

import elior.com.infrastructurekotlin.data.models.Events
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface GetDataService {

    @GET
    suspend fun getAllActivities(@Url url: String?): Response<Events>

}
