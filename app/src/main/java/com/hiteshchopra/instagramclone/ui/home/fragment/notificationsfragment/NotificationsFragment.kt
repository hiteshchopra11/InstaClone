package com.hiteshchopra.instagramclone.ui.home.fragment.notificationsfragment

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hiteshchopra.data.local.notifications.entity.NotificationEntity
import com.hiteshchopra.domain.model.Notification
import com.hiteshchopra.instagramclone.R
import com.hiteshchopra.instagramclone.databinding.FragmentNotificationsBinding
import com.hiteshchopra.instagramclone.ui.base.BaseFragment
import com.hiteshchopra.instagramclone.ui.home.fragment.notificationsfragment.adapter.NotificationAdapter

class NotificationsFragment :
    BaseFragment<FragmentNotificationsBinding, NotificationsFragmentVM>() {

    override fun getViewModelClass(): Class<NotificationsFragmentVM> =
        NotificationsFragmentVM::class.java

    override fun layoutId(): Int = R.layout.fragment_notifications

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getNotifications()
        hideTextViewVisibility()
        initObservers()
    }

    private fun initObservers() {
        viewModel.notificationsState.observe(viewLifecycleOwner, { state ->
            when (state) {
                is NotificationsState.Loading -> {
                    showProgressBar(true)
                }
                is NotificationsState.Failure -> {
                    showProgressBar(false)
                    setErrorTextView(state.error)
                }
                is NotificationsState.NetworkError -> {
                    showProgressBar(false)
                    setErrorTextView(getString(R.string.network_error))
                }
                is NotificationsState.Success -> {
                    showProgressBar(false)
                    addToRecycleView(state.data)
                }
            }
        })
    }

    private fun addToRecycleView(data: List<NotificationEntity>) {
        val notificationAdapter = NotificationAdapter(data)
        binding.rvNotifications.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayout.VERTICAL, false)
            adapter = notificationAdapter
        }
    }

    private fun showProgressBar(bool: Boolean) {
        if (bool)
            binding.pbNotifications.visibility = View.VISIBLE
        else
            binding.pbNotifications.visibility = View.GONE
    }

    private fun setErrorTextView(value: String) {
        binding.tvError.apply {
            visibility = View.VISIBLE
            text = value
        }
    }

    private fun hideTextViewVisibility() {
        binding.tvError.visibility = View.GONE
    }

}