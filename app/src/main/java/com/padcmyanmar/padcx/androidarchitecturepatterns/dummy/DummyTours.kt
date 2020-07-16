package com.padcmyanmar.padcx.androidarchitecturepatterns.dummy

import com.padcmyanmar.padcx.androidarchitecturepatterns.data.vos.ScoresReviewVO
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.vos.ToursAndCountryVO
import com.padcmyanmar.padcx.androidarchitecturepatterns.data.vos.ToursVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 7/13/2020.
 */

fun getDummyTours() : ToursAndCountryVO {

    val dataOne = ToursAndCountryVO()
    val tourOne = ToursVO()
    val scoreTourOne = ScoresReviewVO()
    val scoreTourTwo = ScoresReviewVO()

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

    scoreTourOne.name = "Booking"
    scoreTourOne.maxScore = 10
    scoreTourOne.totalReviews = 140
    scoreTourOne.score = 8.0

    scoreTourTwo.name = "Hotel Out"
    scoreTourTwo.maxScore = 5
    scoreTourTwo.totalReviews = 80
    scoreTourTwo.score = 4.5

    tourOne.scoresAndReviews = arrayListOf(scoreTourOne,scoreTourTwo)


    val tourTwo = ToursVO()
    var scoreTourThree = ScoresReviewVO()
    var scoreTourFour = ScoresReviewVO()

    tourTwo.name = "Pullman Phuket Arcadia Naithon Beach"
    tourTwo.description = "Perched on the headland overlooking the crystal waters of the Andaman Sea."
    tourTwo.location = "22/2 Moo 4 Tambon Saku, Amphur Talang, 83110 Phuket Thailand"
    tourTwo.averageRating = 5.00
    tourTwo.photos = arrayListOf(
        "https://d2e5ushqwiltxm.cloudfront.net/wp-content/uploads/sites/65/2019/01/08043034/Phuket-Resort.png",
        "https://d2e5ushqwiltxm.cloudfront.net/wp-content/uploads/sites/65/2019/01/08043034/Phuket-Resort.png",
        "https://d2e5ushqwiltxm.cloudfront.net/wp-content/uploads/sites/65/2019/01/08043034/Phuket-Resort.png")

    scoreTourThree.name = "Booking"
    scoreTourThree.maxScore = 3
    scoreTourThree.totalReviews = 50
    scoreTourThree.score = 4.0

    scoreTourFour.name = "Hotel Out"
    scoreTourFour.maxScore = 5
    scoreTourFour.totalReviews = 10
    scoreTourFour.score = 2.0

    tourTwo.scoresAndReviews = arrayListOf(scoreTourThree)

    dataOne.tours = arrayListOf(tourOne, tourTwo)
    dataOne.countries = arrayListOf(tourOne, tourTwo)

    return dataOne
}