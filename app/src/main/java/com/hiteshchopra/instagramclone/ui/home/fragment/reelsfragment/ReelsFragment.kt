package com.hiteshchopra.instagramclone.ui.home.fragment.reelsfragment

import android.os.Bundle
import android.view.View
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.hiteshchopra.instagramclone.R
import com.hiteshchopra.instagramclone.databinding.FragmentReelsBinding
import com.hiteshchopra.instagramclone.ui.base.BaseFragment

class ReelsFragment : BaseFragment<FragmentReelsBinding, ReelsFragmentVM>(), Player.EventListener {
    private lateinit var player: SimpleExoPlayer

    override fun getViewModelClass(): Class<ReelsFragmentVM> = ReelsFragmentVM::class.java

    override fun layoutId(): Int = R.layout.fragment_reels


    private val dataSourceFactory: DataSource.Factory by lazy {
        DefaultDataSourceFactory(requireContext(), "exoplayer-sample")
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*ExoPlayer instances must be accessed from a single application thread.
         For the vast majority of cases this should be the application’s main thread*/

        player = SimpleExoPlayer.Builder(requireContext()).build()
        // Bind the player to the view.
        binding.pvReels.player = player
        // Build the media item.
        val mediaItem: MediaItem =
            MediaItem.fromUri("https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4")
        // Set the media item to be played.
        player.setMediaItem(mediaItem)
        // Prepare the player.
        player.prepare()

        // Start the playback.
        player.play()
    }
}