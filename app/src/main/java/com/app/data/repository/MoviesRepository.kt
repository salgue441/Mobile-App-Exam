package com.app.data.repository

import com.app.data.models.Response
import com.app.data.remote.MoviesAPI

class MoviesRepository(private val api: MoviesAPI) {
    suspend fun getPopularMovies(): Response {
        return api.getPopularMovies()
    }
}