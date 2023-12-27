package com.example.appfilmes.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appfilmes.R

class ImageAdapter(private val items: List<ImageItem>) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val textView: TextView = view.findViewById(R.id.textViewTitle)
        val favoriteIcon:ImageView = view.findViewById(R.id.favoriteIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.imagem_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.textView.text = item.title
        Glide.with(holder.imageView.context)
            .load(item.imageUrl)
            .into(holder.imageView)

        holder.favoriteIcon.setOnClickListener {

            item.isFavorite = !item.isFavorite
            holder.favoriteIcon.setImageResource(if (item.isFavorite) R.drawable.baseline_favorite_24_2 else R.drawable.baseline_favorite_24)
        }


        holder.favoriteIcon.setImageResource(if (item.isFavorite) R.drawable.baseline_favorite_24_2 else R.drawable.baseline_favorite_24)
    }




    override fun getItemCount() = items.size




}
