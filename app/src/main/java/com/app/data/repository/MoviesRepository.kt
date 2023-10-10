package com.app.data.repository

import android.util.Log
import com.app.data.models.Movies
import com.app.data.remote.MoviesAPI

/**
 * Repository class for Movies
 *
 * @property api [MoviesAPI] - API interface for Movies
 * @constructor Create empty Movies repository
 *
 * @since 1.0.0
 */
class MoviesRepository(private val api: MoviesAPI) {

    /**
     * Get popular movies
     *
     * @return [Response] - Response object
     * @since 1.0.0
     */
    suspend fun getPopularMovies(): Movies {
        Log.d("REPO", api.getPopularMovies().toString())
        return api.getPopularMovies()
    }
}