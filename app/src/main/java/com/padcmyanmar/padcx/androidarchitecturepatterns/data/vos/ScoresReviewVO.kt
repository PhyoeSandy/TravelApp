package com.padcmyanmar.padcx.androidarchitecturepatterns.data.vos

import com.google.gson.annotations.SerializedName

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/20/2020.
 */
data class ScoresReviewVO (
    @SerializedName("name") var name: String = "",
    @SerializedName("score") var score: Double = 0.0,
    @SerializedName("max_score") var maxScore: Int = 0,
    @SerializedName("total_reviews") var totalReviews: Int = 0
)