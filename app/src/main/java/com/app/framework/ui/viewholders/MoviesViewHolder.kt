package com.app.framework.ui.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.R

/**
 * Holder for the movie card layout.
 *
 * @property itemView: [View] The view of the item.
 * @since 1.0.0
 */
class MoviesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView = itemView.findViewById(R.id.postImageView)
    val title: TextView = itemView.findViewById(R.id.titleTextView)
}