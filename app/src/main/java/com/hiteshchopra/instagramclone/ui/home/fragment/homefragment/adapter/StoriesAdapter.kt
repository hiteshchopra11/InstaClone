package com.hiteshchopra.instagramclone.ui.home.fragment.homefragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hiteshchopra.domain.model.Stories
import com.hiteshchopra.instagramclone.databinding.StoryItemBinding

class StoriesAdapter(
    private val list: List<Stories>,
) :
    RecyclerView.Adapter<StoriesAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: StoryItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            StoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.story = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }
}