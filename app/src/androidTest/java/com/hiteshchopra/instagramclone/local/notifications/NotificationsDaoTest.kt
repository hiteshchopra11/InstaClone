package com.hiteshchopra.instagramclone.local.notifications

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.hiteshchopra.data.local.notifications.NotificationDB
import com.hiteshchopra.data.local.notifications.entity.NotificationEntity
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
class NotificationsDaoTest : TestCase() {
    private lateinit var db: NotificationDB

    @Before
    fun initDb() {
        // get context -- since this is an instrumental test it requires
        // context from the running application
        val context = ApplicationProvider.getApplicationContext<Context>()
        // initialize the db and dao variable
        db = Room.inMemoryDatabaseBuilder(context, NotificationDB::class.java).build()
    }


    @After
    fun closeDB() {
        db.close()
    }

    @Test
    fun insertNotificationListSavesData() = runBlocking {
        val notificationList =
            listOf(
                NotificationEntity("TEST", "TEST", "TEST", "TEST", "TEST"),
                NotificationEntity("TEST", "TEST", "TEST", "TEST", "TEST")
            )
        db.getNotificationsDao().insertNotifications(notificationList)

        val notifications = db.getNotificationsDao().getNotifications().first()
        assert(notifications.isNotEmpty())
    }

    @Test
    fun getNotificationsRetrievesData() = runBlocking {
        val notificationList =
            listOf(
                NotificationEntity("TEST", "TEST", "TEST", "TEST", "TEST"),
                NotificationEntity("TEST", "TEST", "TEST", "TEST", "TEST")
            )
        db.getNotificationsDao().insertNotifications(notificationList)
        val notifications = db.getNotificationsDao().getNotifications().first()
        assert(notifications.contains(notificationList[0]))
    }
}