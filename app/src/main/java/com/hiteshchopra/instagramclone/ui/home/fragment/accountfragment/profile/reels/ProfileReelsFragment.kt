package com.hiteshchopra.instagramclone.ui.home.fragment.accountfragment.profile.reels

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.hiteshchopra.instagramclone.R
import com.hiteshchopra.instagramclone.databinding.FragmentProfileReelsBinding
import com.hiteshchopra.instagramclone.ui.base.BaseFragment
import com.hiteshchopra.instagramclone.ui.home.fragment.accountfragment.AccountFragmentVM
import com.hiteshchopra.instagramclone.ui.home.fragment.accountfragment.ProfileState
import com.hiteshchopra.instagramclone.ui.home.fragment.reelsfragment.utils.ReelsListener


class ProfileReelsFragment : BaseFragment<FragmentProfileReelsBinding, ProfileReelsFragmentVM>(),
    ReelsListener {
    override fun getViewModelClass(): Class<ProfileReelsFragmentVM> =
        ProfileReelsFragmentVM::class.java

    override fun layoutId(): Int = R.layout.fragment_profile_reels

    lateinit var viewPagerAdapter: ProfileReelsViewPagerAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(
            requireActivity(),
            viewModelFactory
        ).get(AccountFragmentVM::class.java)

        initObservers(viewModel)
    }


    private fun initObservers(viewModel: AccountFragmentVM) {
        viewModel.profileState.observe(viewLifecycleOwner, { profileState ->
            when (profileState) {
                is ProfileState.Loading -> {
                    setProgressBarVisible(true)
                }
                is ProfileState.ShowData -> {
                    viewPagerAdapter =
                        ProfileReelsViewPagerAdapter(profileState.profile.reels)
                    viewPagerAdapter.setListener(this@ProfileReelsFragment)
                    binding.viewPager2.adapter = viewPagerAdapter
                    binding.viewPager2.orientation = ViewPager2.ORIENTATION_VERTICAL
                }
                is ProfileState.Error -> {
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