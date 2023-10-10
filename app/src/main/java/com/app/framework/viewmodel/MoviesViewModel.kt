package com.app.framework.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.data.models.Movies
import com.app.data.repository.MoviesRepository

class MoviesViewModel(private val repository: MoviesRepository): ViewModel() {
    private val _movies = MutableLiveData<Movies>()
    val movies: LiveData<Movies> get() = _movies

    suspend fun getPopularMovies() {
        val moviesList = repository.getPopularMovies()
        Log.d("ViewModel", moviesList.toString())
        _movies.value = moviesList
    }

}