package com.app.data.remote

import com.app.data.models.Response
import retrofit2.http.GET

interface MoviesAPI {
    @GET("/movies/popular/")
    suspend fun getPopularMovies(): Response
}