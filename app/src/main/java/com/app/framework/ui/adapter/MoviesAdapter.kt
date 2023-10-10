package com.app.framework.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.R
import com.app.data.models.Movies
import com.app.framework.ui.viewholders.MoviesViewHolder
import com.app.utils.Constants
import com.bumptech.glide.Glide

/**
 * Adpater for the movies cards
 * @property movies: [Movies] - JSON from the TMDB api
 * @constructor [MoviesAdapter]
 * @since 1.0.0
 */
class MoviesAdapter(private val movies: Movies) : RecyclerView.Adapter<MoviesViewHolder>() {
    /**
     * Returns the movies size
     * @since 1.0.0
     */
    override fun getItemCount(): Int = movies.results.size

    /**
     * Sets the cards contents
     *
     * @param holder: [MoviesViewHolder] - View holder
     * @param position: [Int] - Postional index
     * @since 1.0.0
     */
    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movies = movies.results[position]

        Glide.with(holder.itemView.context)
            .load(Constants.IMAGE_URL + movies.posterPath)
            .into(holder.imageView)

        holder.title.text = movies.title
        holder.description.text = movies.overview
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