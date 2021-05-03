package com.hiteshchopra.instagramclone.ui.home.fragment.accountfragment.profile.reels

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hiteshchopra.instagramclone.databinding.ItemProfileReelsBinding
import com.hiteshchopra.instagramclone.ui.home.fragment.reelsfragment.utils.ReelsListener

class ProfileReelsViewPagerAdapter(
    private val reels: List<String>,
) : RecyclerView.Adapter<ProfileReelsVideoViewHolder>() {
    private var reelsListener: ReelsListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileReelsVideoViewHolder {
        return ProfileReelsVideoViewHolder(
            ItemProfileReelsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), reelsListener
        )
    }

    override fun onBindViewHolder(holder: ProfileReelsVideoViewHolder, position: Int) {
        holder.setData(reels[position])
    }

    override fun getItemCount(): Int {
        return reels.size
    }

    fun setListener(reelsListener: ReelsListener) {
        this.reelsListener = reelsListener
    }

}

class ProfileReelsVideoViewHolder(
    private val itemBinding: ItemProfileReelsBinding,
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