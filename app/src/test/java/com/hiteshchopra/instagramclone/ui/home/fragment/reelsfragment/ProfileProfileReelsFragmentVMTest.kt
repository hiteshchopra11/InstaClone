package com.hiteshchopra.instagramclone.ui.home.fragment.reelsfragment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.domain.usecase.UseCaseReels
import com.hiteshchopra.instagramclone.utils.DummyDataUtils
import com.hiteshchopra.instagramclone.utils.TestCoroutineRule
import com.hiteshchopra.instagramclone.utils.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProfileProfileReelsFragmentVMTest {
    @ExperimentalCoroutinesApi
    @get: Rule
    val testCoroutineRule = TestCoroutineRule()

    @get: Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    val mainDispatcher = TestCoroutineDispatcher()

    @MockK
    lateinit var getUseCaseReels: UseCaseReels

    @ExperimentalCoroutinesApi
    @Before
    fun doSetup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        Dispatchers.setMain(mainDispatcher)
    }

    @ExperimentalCoroutinesApi
    @After
    fun teardown() {
        Dispatchers.resetMain()
    }

    private suspend fun mockGetReelsUseCasePerformSuccess() {
        coEvery {
            getUseCaseReels.perform()
        } returns ApiSafeResult.Success(DummyDataUtils.getReels())
    }

    private suspend fun mockGetReelsUseCasePerformNetworkError() {
        coEvery {
            getUseCaseReels.perform()
        } returns ApiSafeResult.NetworkError
    }

    private suspend fun mockGetReelsUseCasePerformFailure() {
        coEvery {
            getUseCaseReels.perform()
        } returns ApiSafeResult.Failure()
    }


    @ExperimentalCoroutinesApi
    @Test
    fun fetchReelsReturnsSuccess() = mainDispatcher.runBlockingTest {
        val viewModel = ReelsFragmentVM(getUseCaseReels)
        mockGetReelsUseCasePerformSuccess()
        viewModel.getReels()
        val value = viewModel.reelsState.getOrAwaitValue()
        assert(value is ReelsState.ShowReels)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun fetchReelsReturnsNetworkError() = mainDispatcher.runBlockingTest {
        val viewModel = ReelsFragmentVM(getUseCaseReels)
        mockGetReelsUseCasePerformNetworkError()
        viewModel.getReels()
        val value = viewModel.reelsState.getOrAwaitValue()
        assert(value is ReelsState.NetworkError)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun fetchReelsReturnsFailure() = mainDispatcher.runBlockingTest {
        val viewModel = ReelsFragmentVM(getUseCaseReels)
        mockGetReelsUseCasePerformFailure()
        viewModel.getReels()
        val value = viewModel.reelsState.getOrAwaitValue()
        assert(value is ReelsState.Failure)
    }
}