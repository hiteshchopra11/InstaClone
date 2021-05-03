package com.hiteshchopra.instagramclone.ui.home.fragment.accountfragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hiteshchopra.data.local.profile.entity.ProfileStories
import com.hiteshchopra.instagramclone.databinding.ProfileStoryItemBinding

class AccountStoriesAdapter(
    private val stories: List<String>,
) : RecyclerView.Adapter<AccountStoriesAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ProfileStoryItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ProfileStoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.story = stories[position]
    }

    override fun getItemCount(): Int {
        return stories.size
    }
}