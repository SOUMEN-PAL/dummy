package com.example.dummy.Presentation.Home.BottomBar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import com.example.dummy.R

data class BottomBarData(
    @DrawableRes val icon: Int,
    @DrawableRes val clickedicon: Int,
    val name: String
)

val groups = listOf(
    BottomBarData(
        icon = R.drawable.shop,
        clickedicon = R.drawable.greenshop,
        name = "Shop"
    ),
    BottomBarData(
        icon = R.drawable.explore,
        clickedicon = R.drawable.greenexplore,
        name = "Explore"
    ),
    BottomBarData(
        icon = R.drawable.cart,
        clickedicon = R.drawable.greencart,
        name = "Cart"
    ),
    BottomBarData(
        icon = R.drawable.favourite,
        clickedicon = R.drawable.greenfavourite,
        name = "Favourite"
    ),
    BottomBarData(
        icon = R.drawable.account,
        clickedicon = R.drawable.greenaccount,
        name = "Account"
    )

)
