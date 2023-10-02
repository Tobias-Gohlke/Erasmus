package com.example.erasmus.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.erasmus.R

data class Activity (
    @StringRes val nameRes: Int,
    @StringRes val titleRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int,
)

object ActivityRepository {
    val activties = listOf(
        Activity(
            nameRes = R.string.day1,
            titleRes = R.string.activity1,
            descriptionRes = R.string.description1,
            imageRes = R.drawable.android_activity1
        ),
        Activity(
            nameRes = R.string.day2,
            titleRes = R.string.activity2,
            descriptionRes = R.string.description2,
            imageRes = R.drawable.android_activity2
        ),
        Activity(
            nameRes = R.string.day3,
            titleRes = R.string.activity3,
            descriptionRes = R.string.description3,
            imageRes = R.drawable.android_activity3
        ),
        Activity(
            nameRes = R.string.day4,
            titleRes = R.string.activity4,
            descriptionRes = R.string.description4,
            imageRes = R.drawable.android_activity4
        ),
        Activity(
            nameRes = R.string.day5,
            titleRes = R.string.activity5,
            descriptionRes = R.string.description5,
            imageRes = R.drawable.android_activity5
        ),
        Activity(
            nameRes = R.string.day6,
            titleRes = R.string.activity6,
            descriptionRes = R.string.description6,
            imageRes = R.drawable.android_activity6
        )
    )
}
