package com.app.framework.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.data.repository.MoviesRepository

/**
 * Custom factory for the recycle view
 * @property repository [MoviesRepository] - Repository to get the movies
 * @constructor [MoviesViewModelFactory]
 *
 * @since 1.0.0
 */
class MoviesViewModelFactory(private val repository: MoviesRepository) :
    ViewModelProvider.Factory {

    /**
     * Overrides the default create method from the factory
     *
     * @param modelClass: [Class] - Class to be created
     * @since 1.0.0
     */
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MoviesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return MoviesViewModel(repository) as T
        }

        throw IllegalArgumentException("Unkown view model class")
    }
}