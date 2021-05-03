package com.hiteshchopra.instagramclone.ui.home.fragment.accountfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.local.profile.entity.ProfileEntity
import com.hiteshchopra.domain.usecase.UseCaseProfile
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class AccountFragmentVM @Inject constructor(
    private val useCaseProfile: UseCaseProfile,
) : ViewModel() {

    private var _profileState: MutableLiveData<ProfileState> = MutableLiveData()
    val profileState: LiveData<ProfileState> = _profileState


    @InternalCoroutinesApi
    fun loadProfile() {
        _profileState.value = ProfileState.Loading
        viewModelScope.launch {
            val result = useCaseProfile.perform("1")
            result.collect { profile ->
                when (profile) {
                    is ApiSafeResult.Success -> {
                        _profileState.value = ProfileState.ShowData(profile.data)
                    }
                    is ApiSafeResult.Failure -> {
                        _profileState.value =
                            profile.data?.let { ProfileState.ShowData(it) }
                    }
                    is ApiSafeResult.NetworkError -> {
                        _profileState.value = ProfileState.Error("Network Error")
                    }
                }
            }
        }
    }
}

sealed class ProfileState {
    object Loading : ProfileState()
    class ShowData(val profile: ProfileEntity) : ProfileState()
    class Error(val message: String?) : ProfileState()
}
