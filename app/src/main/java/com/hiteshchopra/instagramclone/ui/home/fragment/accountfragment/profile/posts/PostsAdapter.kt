package com.hiteshchopra.instagramclone.ui.home.fragment.accountfragment.profile.posts

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hiteshchopra.instagramclone.databinding.ItemProfilePostBinding

class PostsAdapter(private val postsList: List<String>) :
    RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    inner class ViewHolder(val itemBinding: ItemProfilePostBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemProfilePostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PostsAdapter.ViewHolder, position: Int) {
        holder.itemBinding.imageUrl = postsList[position]
    }

    override fun getItemCount(): Int {
        return postsList.size
    }
}