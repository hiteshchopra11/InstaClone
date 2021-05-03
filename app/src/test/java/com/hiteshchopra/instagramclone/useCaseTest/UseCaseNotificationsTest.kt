package com.hiteshchopra.instagramclone.useCaseTest

import com.hiteshchopra.data.ApiSafeResult
import com.hiteshchopra.domain.usecase.UseCaseNotifications
import com.hiteshchopra.instagramclone.BaseTest
import com.hiteshchopra.instagramclone.injection.component.TestAppComponent
import com.hiteshchopra.instagramclone.utils.FileUtil
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import okhttp3.mockwebserver.MockResponse
import org.junit.Test
import javax.inject.Inject

//@ExperimentalCoroutinesApi
//class UseCaseNotificationsTest : BaseTest() {
//    override fun injectIntoDagger(testAppComponent: TestAppComponent) {
//        testAppComponent.inject(this)
//    }
//
//    @Inject
//    lateinit var useCaseNotifications: UseCaseNotifications
//
//
//    @Test
//    fun `when api returns success- assert result data contains Reels`() =
//        runBlockingTest {
//            mockWebServer.enqueue(
//                MockResponse().setResponseCode(200)
//                    .setBody(FileUtil.loadText("responses/notification_response.json"))
//            )
//
//            val result = useCaseNotifications.perform().first()
//            assert(result is ApiSafeResult.Success)
//            assert((result as ApiSafeResult.Success).data.isNotEmpty())
//        }
//}