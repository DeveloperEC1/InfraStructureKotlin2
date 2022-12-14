package elior.com.infrastructurekotlin.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientInstance {

    companion object {

        private const val BASE_URL = "https://api.themoviedb.org"

        fun getRetrofitClientInstance(): GetDataService? {

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(GetDataService::class.java)
        }
    }

}
