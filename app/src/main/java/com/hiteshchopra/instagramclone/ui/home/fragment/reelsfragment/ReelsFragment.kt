package com.hiteshchopra.instagramclone.ui.home.fragment.reelsfragment

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.viewpager2.widget.ViewPager2
import com.hiteshchopra.instagramclone.R
import com.hiteshchopra.instagramclone.databinding.FragmentReelsBinding
import com.hiteshchopra.instagramclone.ui.base.BaseFragment
import com.hiteshchopra.instagramclone.ui.home.fragment.reelsfragment.utils.ReelsListener
import com.hiteshchopra.instagramclone.ui.home.fragment.reelsfragment.utils.adapter.ViewPagerVideoAdapter

class ReelsFragment : BaseFragment<FragmentReelsBinding, ReelsFragmentVM>(), ReelsListener {

    lateinit var viewPagerAdapter: ViewPagerVideoAdapter
    override fun getViewModelClass(): Class<ReelsFragmentVM> = ReelsFragmentVM::class.java

    override fun layoutId(): Int = R.layout.fragment_reels

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        setErrorTextViewVisibility(false)
        viewModel.getReels()
    }


    private fun initObservers() {
        viewModel.reelsState.observe(viewLifecycleOwner, { state ->
            when (state) {
                is ReelsState.Loading -> {
                    setProgressBarVisible(true)
                }
                is ReelsState.ShowReels -> {
                    viewPagerAdapter = ViewPagerVideoAdapter(state.data)
                    viewPagerAdapter.setListener(this@ReelsFragment)
                    binding.viewPager2.adapter = viewPagerAdapter
                    binding.viewPager2.orientation = ViewPager2.ORIENTATION_VERTICAL
                }
                is ReelsState.Failure -> {
                    setProgressBarVisible(false)
                    setErrorText(state.message)
                    setErrorTextViewVisibility(true)
                }
                is ReelsState.NetworkError -> {
                    setProgressBarVisible(false)
                    setErrorText(getString(R.string.network_error))
                    setErrorTextViewVisibility(true)
                }
            }
        })
    }

    private fun setProgressBarVisible(bool: Boolean) {
        if (bool) {
            binding.pbReels.visibility = View.VISIBLE
        } else {
            binding.pbReels.visibility = View.GONE
        }
    }

    private fun setErrorTextViewVisibility(bool: Boolean) {
        if (bool) {
            binding.tvError.visibility = View.VISIBLE
        } else {
            binding.tvError.visibility = View.GONE
        }
    }

    private fun setErrorText(value: String) {
        binding.tvError.text = value
    }

    override fun removeProgressBar() {
        setProgressBarVisible(false)
    }

    override fun moveToNextVideo() {
        binding.viewPager2.setCurrentItem(binding.viewPager2.currentItem + 1, true)
    }

    override fun setError(string: String) {
        setErrorText(string)
    }
}