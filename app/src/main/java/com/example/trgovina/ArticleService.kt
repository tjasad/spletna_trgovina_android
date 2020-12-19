package com.example.trgovina

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

object ArticleService {

    interface RestApi {

        companion object {
            // AVD emulator
            const val URL = "http://10.0.2.2:8080/netbeans/seminarska_naloga/index.php/seminarska_naloga/api/"
        }

        @GET("artikli")
        fun getAll(): Call<List<Article>>
    }

    val instance: RestApi by lazy {
        val retrofit = Retrofit.Builder()
                .baseUrl(RestApi.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        retrofit.create(RestApi::class.java)
    }
}
