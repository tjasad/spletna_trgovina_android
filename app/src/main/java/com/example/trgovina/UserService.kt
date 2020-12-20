package com.example.trgovina

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

object UserService {

    interface RestApi {

        companion object {
            // AVD emulator
            const val URL = "http://10.0.2.2:8080/netbeans/seminarska_naloga/index.php/seminarska_naloga/api/"
        }

        @GET("prijava")
        fun logIn(@Query("email") email: String, @Query("password") id: String ): Call<User>

        @FormUrlEncoded
        @POST("urediProfil")
        fun update(@Field("id") id: String,
                   @Field("name") name: String,
                   @Field("surname") surname: String,
                   @Field("street") street: String,
                   @Field("house_number") house_number: String,
                   @Field("post") post: String,
                   @Field("post_number") post_number: String,
                   @Field("email") email: String): Call<Void>
    }

    val instance: RestApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(RestApi.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(RestApi::class.java)
    }
}
