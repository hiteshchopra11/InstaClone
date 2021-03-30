package com.hiteshchopra.instagramclone

import android.os.Build
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.hiteshchopra.instagramclone.injection.component.TestAppComponent
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@Config(application = TestApplication::class, sdk = [Build.VERSION_CODES.O_MR1])
abstract class BaseTest {

    private lateinit var application: TestApplication

    @Before
    open fun setup() {
        application = ApplicationProvider.getApplicationContext() as TestApplication
        injectIntoDagger(application.provideComponent())
    }

    abstract fun injectIntoDagger(testAppComponent: TestAppComponent)

}