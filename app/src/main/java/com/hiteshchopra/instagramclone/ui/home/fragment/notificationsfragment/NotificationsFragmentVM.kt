package com.hiteshchopra.instagramclone.ui.home.fragment.notificationsfragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.local.notifications.entity.NotificationEntity
import com.hiteshchopra.domain.usecase.UseCaseNotifications
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class NotificationsFragmentVM @Inject constructor(
    private val useCaseNotifications: UseCaseNotifications
) : ViewModel() {

    private val _notificationState: MutableLiveData<NotificationsState> = MutableLiveData()
    val notificationsState: LiveData<NotificationsState>
        get() = _notificationState

    fun getNotifications() {
        _notificationState.value = NotificationsState.Loading
        viewModelScope.launch {
            val result = useCaseNotifications.perform()
            result.collect { result ->
                when (result) {
                    is ApiSafeResult.Failure -> {
                        _notificationState.value =
                            result.data?.let { NotificationsState.Success(it) }
                    }
                    is ApiSafeResult.NetworkError -> {
                        _notificationState.value =
                            NotificationsState.NetworkError
                    }
                    is ApiSafeResult.Success ->{
                        _notificationState.value =
                        NotificationsState.Success(result.data)}
                }
            }
        }
    }
}


sealed class NotificationsState {
    object Loading : NotificationsState()
    class Success(val data: List<NotificationEntity>) : NotificationsState()
    class Failure(val error: String) : NotificationsState()
    object NetworkError : NotificationsState()
}