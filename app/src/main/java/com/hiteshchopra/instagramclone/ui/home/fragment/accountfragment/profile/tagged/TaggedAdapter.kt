package com.hiteshchopra.instagramclone.ui.home.fragment.accountfragment.profile.tagged

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hiteshchopra.instagramclone.databinding.ItemProfileTaggedBinding

class TaggedAdapter(private val taggedList: List<String>) :
    RecyclerView.Adapter<TaggedAdapter.ViewHolder>() {

    inner class ViewHolder(val itemBinding: ItemProfileTaggedBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemProfileTaggedBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TaggedAdapter.ViewHolder, position: Int) {
        holder.itemBinding.imageUrl = taggedList[position]
    }

    override fun getItemCount(): Int {
        return taggedList.size
    }
}