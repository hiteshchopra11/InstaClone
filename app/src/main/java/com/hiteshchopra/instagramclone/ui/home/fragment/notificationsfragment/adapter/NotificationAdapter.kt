package com.hiteshchopra.instagramclone.ui.home.fragment.notificationsfragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hiteshchopra.data.local.notifications.entity.NotificationEntity
import com.hiteshchopra.domain.model.Notification
import com.hiteshchopra.instagramclone.databinding.ItemNotificationHeadingBinding
import com.hiteshchopra.instagramclone.databinding.ItemNotificationListBinding

class NotificationAdapter(
    private val list: List<NotificationEntity>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_HEADING = 1
        const val VIEW_TYPE_LIST = 2
    }

    override fun getItemViewType(position: Int): Int {
        return if (list[position].heading != null)
            VIEW_TYPE_HEADING
        else
            VIEW_TYPE_LIST
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_HEADING) {
            return NotificationHeadingViewHolder(
                ItemNotificationHeadingBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        } else {
            return NotificationListViewHolder(
                ItemNotificationListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is NotificationHeadingViewHolder) {
            holder.binding.heading = list[position].heading
        } else if (holder is NotificationListViewHolder) {
            holder.binding.notification = list[position]
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class NotificationListViewHolder(val binding: ItemNotificationListBinding) :
    RecyclerView.ViewHolder(binding.root)

class NotificationHeadingViewHolder(val binding: ItemNotificationHeadingBinding) :
    RecyclerView.ViewHolder(binding.root)