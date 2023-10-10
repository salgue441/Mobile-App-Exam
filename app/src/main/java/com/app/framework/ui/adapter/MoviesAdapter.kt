package com.app.framework.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.R
import com.app.data.models.Response
import com.app.framework.ui.viewholders.MoviesViewHolder

class MoviesAdapter(private val moviesList: Response) : RecyclerView.Adapter<MoviesViewHolder>() {
    override fun getItemCount(): Int = moviesList.movies.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movies = moviesList.movies[position]
        Log.d("MOVIES", movies.toString())
    }

    /**
     * This method is called right when the adapter is created and is used to initialize
     * the ViewHolder. Inflates the card_layout.xml layout file, and returns an instance
     * of the MoviesViewHolder class.
     *
     * @param parent: [ViewGroup] The ViewGroup into which the new View will be added after
     *                            it is bound to an adapter position.
     * @param viewType: [Int] The view type of the new View.
     * @return [MoviesViewHolder] A new ViewHolder that holds a View of the given view type.
     * @since 1.0.0
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.card_layout,
            parent,
            false
        )

        return MoviesViewHolder(itemView)
    }
}