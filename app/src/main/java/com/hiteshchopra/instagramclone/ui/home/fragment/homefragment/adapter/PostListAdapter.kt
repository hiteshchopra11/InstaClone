package com.hiteshchopra.instagramclone.ui.home.fragment.homefragment.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hiteshchopra.data.local.posts.entity.PostsEntity
import com.hiteshchopra.instagramclone.databinding.PostItemBinding

class PostListAdapter : ListAdapter<PostsEntity, PostViewHolder>(PostDiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            PostItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        Log.e("GETITEM", getItem(position).storiesImage.toString())
        holder.itemBinding.post = getItem(position)
    }
}

class PostViewHolder(val itemBinding: PostItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

}

class PostDiffUtilCallback() : DiffUtil.ItemCallback<PostsEntity>() {
    override fun areItemsTheSame(oldItem: PostsEntity, newItem: PostsEntity): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: PostsEntity, newItem: PostsEntity): Boolean {
        return oldItem == newItem
    }

}