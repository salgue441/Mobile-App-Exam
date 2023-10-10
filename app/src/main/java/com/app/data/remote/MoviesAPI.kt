package com.app.data.remote

import com.app.data.models.Movies
import retrofit2.http.GET

interface MoviesAPI {
    @GET("movie/popular/")
    suspend fun getPopularMovies(): Movies
}