package com.app.data.remote

import com.app.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MoviesClient {
    private val gsonFactory = GsonConverterFactory.create()
    val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    /**
     * Interceptor to add the logger and the API key to the request.
     *
     * @since 1.0.0
     */
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .addInterceptor { chain ->
            val newRequest: Request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer ${Constants.API_KEY}")
                .build()
            chain.proceed(newRequest)
        }.build()

    /**
     * Retrofit instance.
     *
     * @since 1.0.0
     */
    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(gsonFactory)
        .client(okHttpClient)
        .build()

    /**
     * API instance to make the API calls.
     *
     * @since 1.0.0
     */
    val api: MoviesAPI = retrofit.create(MoviesAPI::class.java)
}