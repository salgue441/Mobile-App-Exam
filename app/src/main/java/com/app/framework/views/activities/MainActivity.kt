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
import com.app.framework.viewmodel.MoviesViewModel
import com.app.framework.viewmodel.MoviesViewModelFactory
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MoviesViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        setUpViewModel()
        setUpRecyclerView()
        fetchData()
    }

    private fun setUpViewModel() {
        val client = MoviesClient
        val repository = MoviesRepository(client.api)
        val viewModelFactory = MoviesViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory)[MoviesViewModel::class.java]
    }

    private fun setUpRecyclerView() {
        recyclerView = findViewById(R.id.rv_movies)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

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
}