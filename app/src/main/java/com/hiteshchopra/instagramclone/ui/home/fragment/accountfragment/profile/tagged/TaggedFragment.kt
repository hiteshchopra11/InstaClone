package com.hiteshchopra.instagramclone.ui.home.fragment.accountfragment.profile.tagged

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.hiteshchopra.data.local.profile.entity.ProfileEntity
import com.hiteshchopra.instagramclone.R
import com.hiteshchopra.instagramclone.databinding.FragmentProfileTaggedBinding
import com.hiteshchopra.instagramclone.ui.base.BaseFragment
import com.hiteshchopra.instagramclone.ui.home.fragment.accountfragment.AccountFragmentVM
import com.hiteshchopra.instagramclone.ui.home.fragment.accountfragment.ProfileState


class TaggedFragment : BaseFragment<FragmentProfileTaggedBinding, TaggedFragmentVM>() {
    override fun getViewModelClass(): Class<TaggedFragmentVM> = TaggedFragmentVM::class.java
    override fun layoutId(): Int = R.layout.fragment_profile_tagged
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
        val taggedAdapter = TaggedAdapter(data.tagged)
        binding.rvTagged.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = taggedAdapter
        }
    }

    private fun initObservers(viewModel: AccountFragmentVM) {
        viewModel.profileState.observe(viewLifecycleOwner, { profileState ->
            when (profileState) {
                is ProfileState.Error -> setProgressBarVisible(true)
                is ProfileState.Loading -> setProgressBarVisible(false)
                is ProfileState.ShowData -> {
                    setProgressBarVisible(false)
                    addDataToRecycleView(profileState.profile)
                }
            }
        })
    }

    private fun setProgressBarVisible(bool: Boolean) {
        if (bool) {
            binding.pbTagged.visibility = View.VISIBLE
        } else {
            binding.pbTagged.visibility = View.GONE
        }
    }
}