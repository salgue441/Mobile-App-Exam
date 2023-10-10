package com.app.data.remote

import com.app.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MoviesClient {
    private val gsonFactory = GsonConverterFactory.create()
    private val okHttpClient = OkHttpClient.Builder().addInterceptor { chain ->
        val newRequest: Request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer ${Constants.API_KEY}")
            .build()
        chain.proceed(newRequest)
    }.build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(gsonFactory)
        .client(okHttpClient)
        .build()

    val api: MoviesAPI = retrofit.create(MoviesAPI::class.java)
}