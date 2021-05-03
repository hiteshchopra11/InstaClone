package com.hiteshchopra.instagramclone.ui.home.fragment.reelsfragment.utils.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hiteshchopra.domain.model.Reels
import com.hiteshchopra.instagramclone.databinding.ReelsVideoViewBinding
import com.hiteshchopra.instagramclone.ui.home.fragment.reelsfragment.utils.ReelsListener

class ViewPagerVideoAdapter(
    private val reels: List<Reels>,
) : RecyclerView.Adapter<ReelsVideoViewHolder>() {
    private var reelsListener: ReelsListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReelsVideoViewHolder {
        return ReelsVideoViewHolder(
            ReelsVideoViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), reelsListener
        )
    }

    override fun onBindViewHolder(holder: ReelsVideoViewHolder, position: Int) {
        holder.setData(reels[position].videos)
    }

    override fun getItemCount(): Int {
        return reels.size
    }

    fun setListener(reelsListener: ReelsListener) {
        this.reelsListener = reelsListener
    }

}

class ReelsVideoViewHolder(
    private val itemBinding: ReelsVideoViewBinding,
    private val reelsListener: ReelsListener?
) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun setData(uri: String) {
        itemBinding.videoView.apply {
            setVideoPath(uri)
            setOnPreparedListener { mediaPlayer ->
                reelsListener?.removeProgressBar()
                mediaPlayer.start()
            }
            setOnCompletionListener {
                reelsListener?.moveToNextVideo()
            }
        }
    }
}
