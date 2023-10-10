package com.app.framework.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.data.models.Movies
import com.app.data.repository.MoviesRepository

class MoviesViewModel(private val repository: MoviesRepository): ViewModel() {
    private val _movies = MutableLiveData<List<Movies>>()
    val movies: LiveData<List<Movies>> get() = _movies

    suspend fun getPopularMovies() {
        val moviesList = repository.getPopularMovies()
        _movies.value = moviesList.movies
    }

}