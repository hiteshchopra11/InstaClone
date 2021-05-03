package com.hiteshchopra.instagramclone.ui.home.fragment.reelsfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.data.local.posts.entity.PostsEntity
import com.hiteshchopra.domain.model.Reels
import com.hiteshchopra.domain.usecase.UseCaseReels
import kotlinx.coroutines.launch
import javax.inject.Inject

class ReelsFragmentVM @Inject constructor(
    private val useCaseReels: UseCaseReels
) : ViewModel() {


    private var _reelsState: MutableLiveData<ReelsState> = MutableLiveData()
    val reelsState: LiveData<ReelsState> = _reelsState

    fun getReels() {
        viewModelScope.launch {
            when (val result = useCaseReels.perform()) {
                is ApiSafeResult.Success -> {
                    _reelsState.value = ReelsState.ShowReels(result.data)
                }
                is ApiSafeResult.Failure -> {
                    _reelsState.value = result.data?.let { ReelsState.ShowReels(it) }
                }
                is ApiSafeResult.NetworkError -> {
                    _reelsState.value = ReelsState.NetworkError
                }
            }
        }
    }
}

sealed class ReelsState {
    object Loading : ReelsState()
    class ShowReels(val data: List<Reels>) : ReelsState()
    class Failure(val message: String) : ReelsState()
    object NetworkError : ReelsState()
}
