package com.hiteshchopra.instagramclone.ui.home.fragment.searchfragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hiteshchopra.domain.model.Image
import com.hiteshchopra.instagramclone.databinding.SearchItemBinding

class ImageAdapter(
    private val list: List<Image>,
) :
    RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: SearchItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            SearchItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.image = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }

}