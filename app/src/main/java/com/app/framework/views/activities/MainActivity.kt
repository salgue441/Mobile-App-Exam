package com.app.framework.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.R
import com.app.data.remote.MoviesClient
import com.app.data.repository.MoviesRepository
import com.app.framework.ui.adapter.MoviesAdapter
import com.app.framework.viewmodel.MoviesViewModel
import com.app.framework.viewmodel.MoviesViewModelFactory
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MoviesViewModel
    private lateinit var recyclerView: RecyclerView

    /**
     * Override the onCreate function
     *
     * @param savedInstanceState: [Bundle]? - Previous instance states
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        setUpViewModel()
        setUpRecyclerView()
        fetchData()
        observeData()
    }

    /**
     * Set ups the view model with the client, repository, and viewModelFactory
     *
     * @since 1.0.0
     */
    private fun setUpViewModel() {
        val client = MoviesClient
        val repository = MoviesRepository(client.api)
        val viewModelFactory = MoviesViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory)[MoviesViewModel::class.java]
    }

    /**
     * Sets up the recycle view
     *
     * @since 1.0.0
     */
    private fun setUpRecyclerView() {
        recyclerView = findViewById(R.id.rv_movies)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    /**
     * Fetches the data from the view model
     *
     * @since 1.0.0
     */
    private fun fetchData() {
        lifecycleScope.launch {
            try {
                viewModel.getPopularMovies()
            } catch (e: Exception) {
                Log.d("ERROR", e.toString())
                e.printStackTrace()
            }
        }
    }

    /**
     * Observes the data with the adapter
     *
     * @since 1.0.0
     */
    private fun observeData() {
        viewModel.movies.observe(this) { movies ->
            recyclerView.adapter = MoviesAdapter(movies)
        }
    }
}