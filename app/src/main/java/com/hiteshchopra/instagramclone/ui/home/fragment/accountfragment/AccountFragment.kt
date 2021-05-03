package com.hiteshchopra.instagramclone.ui.home.fragment.accountfragment

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayoutMediator
import com.hiteshchopra.data.local.profile.entity.Profile
import com.hiteshchopra.data.local.profile.entity.ProfileEntity
import com.hiteshchopra.data.local.profile.entity.ProfileWithStories
import com.hiteshchopra.instagramclone.R
import com.hiteshchopra.instagramclone.databinding.FragmentAccountScreenBinding
import com.hiteshchopra.instagramclone.ui.base.BaseFragment
import com.hiteshchopra.instagramclone.ui.home.fragment.accountfragment.adapter.AccountStoriesAdapter
import com.hiteshchopra.instagramclone.ui.home.fragment.accountfragment.adapter.AccountViewPagerAdapter
import com.hiteshchopra.instagramclone.ui.home.fragment.accountfragment.profile.posts.PostsFragment
import com.hiteshchopra.instagramclone.ui.home.fragment.accountfragment.profile.reels.ProfileReelsFragment
import com.hiteshchopra.instagramclone.ui.home.fragment.accountfragment.profile.tagged.TaggedFragment
import kotlinx.coroutines.InternalCoroutinesApi

class AccountFragment : BaseFragment<FragmentAccountScreenBinding, AccountFragmentVM>() {
    override fun layoutId(): Int = R.layout.fragment_account_screen
    override fun getViewModelClass(): Class<AccountFragmentVM> = AccountFragmentVM::class.java
    lateinit var model: AccountFragmentVM

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model = ViewModelProvider(
            requireActivity(),
            viewModelFactory
        ).get(AccountFragmentVM::class.java)
        handleDataLoadingUi(false)
        model.loadProfile()
        addObservers(model)
    }

    private fun addObservers(model: AccountFragmentVM) {
        model.profileState.observe(viewLifecycleOwner, { state ->
            when (state) {
                is ProfileState.Loading -> {
                    handleDataLoadingUi(true)
                }
                is ProfileState.ShowData -> {
                    handleDataLoadingUi(false)
                    setupViewPagerAndTabMediator()
                    setDataToViews(state.profile)
                    addStoriesToRecycleView(state.profile.stories)
                }
                is ProfileState.Error -> {
                    handleDataLoadingUi(false)
                }
            }
        })
    }


    private fun setupViewPagerAndTabMediator() {
        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPagerProfile
        val viewPagerAdapter = AccountViewPagerAdapter(this)

        val fragsList = listOf(PostsFragment(), ProfileReelsFragment(), TaggedFragment())

        val iconList = listOf(
            R.drawable.ic_square_grid,
            R.drawable.ic_baseline_reels,
            R.drawable.ic_account
        )

        viewPagerAdapter.fragmentList.addAll(fragsList)

        binding.viewPagerProfile.apply {
            offscreenPageLimit = 3
            adapter = viewPagerAdapter
            currentItem = 0
        }

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.icon = getDrawable(requireContext(), iconList[position])
        }.attach()
    }

    private fun addStoriesToRecycleView(list: List<String>) {
        binding.rvStories.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayout.HORIZONTAL, false)
            adapter = AccountStoriesAdapter(list)
        }
    }

    private fun handleDataLoadingUi(loading: Boolean) {
        with(binding) {
            pbStories.isVisible = loading
        }
    }

    private fun setDataToViews(profile: ProfileEntity) {
        binding.apply {
            tvUsername.text = profile.username
            tvBio.text = profile.profile_bio
            tvPostsCount.text = profile.posts_count.toString()
            tvFollowersCount.text = profile.followers_count.toString()
            tvFollowingCount.text = profile.following_count.toString()
            imageUrl = profile.profile_pic
        }
    }
}