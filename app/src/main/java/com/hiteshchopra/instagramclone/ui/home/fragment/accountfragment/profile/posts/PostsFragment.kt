package com.hiteshchopra.instagramclone.ui.home.fragment.accountfragment.profile.posts

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.hiteshchopra.data.local.profile.entity.ProfileEntity
import com.hiteshchopra.instagramclone.R
import com.hiteshchopra.instagramclone.databinding.FragmentProfilePostsBinding
import com.hiteshchopra.instagramclone.ui.base.BaseFragment
import com.hiteshchopra.instagramclone.ui.home.fragment.accountfragment.AccountFragmentVM
import com.hiteshchopra.instagramclone.ui.home.fragment.accountfragment.ProfileState


class PostsFragment : BaseFragment<FragmentProfilePostsBinding, PostsFragmentVM>() {

    override fun getViewModelClass(): Class<PostsFragmentVM> =
        PostsFragmentVM::class.java

    override fun layoutId(): Int = R.layout.fragment_profile_posts
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setProgressBarVisible(false)
        val viewModel = ViewModelProvider(
            requireActivity(),
            viewModelFactory
        ).get(AccountFragmentVM::class.java)

        initObservers(viewModel)
    }

    private fun addDataToRecycleView(data: ProfileEntity) {
        val postsAdapter = PostsAdapter(data.posts)
        binding.rvPosts.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = postsAdapter
        }
    }

    private fun initObservers(viewModel: AccountFragmentVM) {
        viewModel.profileState.observe(viewLifecycleOwner, { profileState ->
            when (profileState) {
                is ProfileState.ShowData -> {
                    setProgressBarVisible(false)
                    addDataToRecycleView(profileState.profile)
                }
                is ProfileState.Error -> setProgressBarVisible(false)
                is ProfileState.Loading -> setProgressBarVisible(true)
            }
        })
    }

    private fun setProgressBarVisible(bool: Boolean) {
        if (bool) {
            binding.pbPosts.visibility = View.VISIBLE
        } else {
            binding.pbPosts.visibility = View.GONE
        }
    }
}