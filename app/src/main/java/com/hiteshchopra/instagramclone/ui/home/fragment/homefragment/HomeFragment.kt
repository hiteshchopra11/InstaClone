package com.hiteshchopra.instagramclone.ui.home.fragment.homefragment

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hiteshchopra.instagramclone.R
import com.hiteshchopra.instagramclone.databinding.FragmentHomeScreenBinding
import com.hiteshchopra.instagramclone.ui.base.BaseFragment
import com.hiteshchopra.instagramclone.ui.home.fragment.homefragment.adapter.PostAdapter
import com.hiteshchopra.instagramclone.ui.home.fragment.homefragment.adapter.StoriesAdapter

class HomeFragment : BaseFragment<FragmentHomeScreenBinding, HomeScreenVM>() {
    override fun getViewModelClass(): Class<HomeScreenVM> = HomeScreenVM::class.java

    override fun layoutId(): Int = R.layout.fragment_home_screen

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadPosts()
        viewModel.loadStories()
        addObservers()
    }

    private fun addObservers() {
        viewModel.postsState.observe(viewLifecycleOwner, { state ->
            when (state) {
                is PostsState.Loading -> {
                    handleDataLoadingUi(true)
                }
                is PostsState.ShowPosts -> {
                    handleDataLoadingUi(false)
                    addPostsToRecycleView(state)
                }
                is PostsState.Error -> {
                    handleDataLoadingUi(false)
                }
            }
        })

        viewModel.storiesState.observe(viewLifecycleOwner, { state ->
            when (state) {
                is StoriesState.Loading -> {
                    handleDataLoadingUi(true)
                }
                is StoriesState.ShowStories -> {
                    handleDataLoadingUi(false)
                    addStoriesToRecycleView(state)
                }
                is StoriesState.Error -> {
                    handleDataLoadingUi(false)
                }
            }
        })

    }

    private fun addPostsToRecycleView(state: PostsState.ShowPosts) {
        binding.rvPosts.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = PostAdapter(state.posts)
        }
    }

    private fun addStoriesToRecycleView(state: StoriesState.ShowStories) {
        binding.rvStories.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayout.HORIZONTAL, false)
            adapter = StoriesAdapter(state.stories)
        }
    }

    private fun handleDataLoadingUi(loading: Boolean) {
        with(binding) {
            pbPost.isVisible = loading
        }
    }
}