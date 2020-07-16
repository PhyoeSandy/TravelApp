package com.padcmyanmar.padcx.androidarchitecturepatterns.instumentation_tests

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.vos.ToursVO
import com.padcmyanmar.padcx.androidarchitecturepatterns.persistence.daos.ToursDao
import com.padcmyanmar.padcx.androidarchitecturepatterns.persistence.db.ToursDB
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Phyoe Sandy Soe Tun
 * on 7/13/2020.
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class DatabaseTest {

    private lateinit var toursDao: ToursDao
    private lateinit var db: ToursDB

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, ToursDB::class.java
        ).build()
        toursDao = db.toursDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun insertIntoDatabaseTest() {
        val tourOne = ToursVO()
        tourOne.name = "Sea Flower Resort"
        tourOne.description = "Located in Ko Chang, within 17.7 km of Koh Chang National Park and parking, a tour desk and ticket service for guests.The resort has a terrace.Klong Plu Waterfall is 9.7 km from Sea Flower Resort, while International Clinic, Ko Chang is 12.9 km away.Lonely Beach is a great choice for travelers interested in friendly locals, sunsets and food."
        tourOne.location = "Koh Chang Thailand"
        tourOne.averageRating = 3.00
        tourOne.photos = arrayListOf(
            "https://r-cf.bstatic.com/images/hotel/max1280x900/175/175821872.jpg",
            "https://r-cf.bstatic.com/images/hotel/max1280x900/100/100195253.jpg",
            "https://r-cf.bstatic.com/images/hotel/max1280x900/100/100195253.jpg",
            "https://r-cf.bstatic.com/images/hotel/max1280x900/100/100195280.jpg",
            "https://r-cf.bstatic.com/images/hotel/max1280x900/999/99977869.jpg")

        toursDao.insertTour(tourOne)
        assert(toursDao.getToursByName(tourOne.name).value?.name.equals(tourOne.name))
    }
}