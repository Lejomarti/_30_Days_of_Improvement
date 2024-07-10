package com.alejo.a30daysofimprovement.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DailyActivity(
    @StringRes val dayRes:Int,
    @StringRes val descriptionRes:Int,
    @DrawableRes val imageRes:Int
)
