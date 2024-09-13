package com.example.dummy.Presentation.Home

import androidx.annotation.DrawableRes
import com.example.dummy.R

data class Item(
    val name: String,
    val price: String,
    val description: String,
    @DrawableRes val image: Int,
    val isfavourite: Boolean = false,
    val inCart: Boolean = false
)

val items = listOf(
    Item(
        name = "organic Bananas",
        price = "$4.99",
        description = "7pcs, priceg",
        image = R.drawable.banana
    ),
    Item(
        name = "Red Apple",
        price = "$4.99",
        description = "7pcs, priceg",
        image = R.drawable.apple
    )
)
