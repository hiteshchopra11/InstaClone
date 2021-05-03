package com.hiteshchopra.instagramclone.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.hiteshchopra.instagramclone.R


object BindingAdapters {
    @JvmStatic
    @BindingAdapter("image")
    fun loadImage(view: ImageView, url: String?) {
        Glide.with(view)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .apply(RequestOptions().error(R.drawable.ic_launcher_background)).into(view)
    }
}