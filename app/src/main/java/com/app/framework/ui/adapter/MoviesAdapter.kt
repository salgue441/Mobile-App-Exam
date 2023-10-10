package com.app.framework.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.R
import com.app.framework.ui.viewholders.MoviesViewHolder

class MoviesAdapter() : RecyclerView.Adapter<MoviesViewHolder>() {
    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
//        val currentItem = moviesList[position]
        TODO("NOT YET IMPLEMENTED")
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