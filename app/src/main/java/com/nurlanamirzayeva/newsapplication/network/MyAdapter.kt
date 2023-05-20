package com.nurlanamirzayeva.newsapplication.network

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.nurlanamirzayeva.newsapplication.R
import com.nurlanamirzayeva.newsapplication.api.models.DTO
import com.squareup.picasso.Picasso
class MyAdapter(val context: Context, val list: List<DTO>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentPosition = list[position]
        holder.title.text = currentPosition.title

        Picasso.get()
            .load(currentPosition.images.get(0))
            .into(holder.image)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tw)
        val image: ImageView = itemView.findViewById(R.id.iw)

    }
}