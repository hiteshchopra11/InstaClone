package com.hiteshchopra.instagramclone.ui.home.fragment.homefragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hiteshchopra.data.local.entity.PostsEntity
import com.hiteshchopra.domain.model.Post
import com.hiteshchopra.instagramclone.databinding.PostItemBinding

class PostAdapter(
    private val list: List<PostsEntity>,
) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: PostItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            PostItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.post = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }
}