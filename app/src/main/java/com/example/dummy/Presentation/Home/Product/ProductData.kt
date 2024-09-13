package com.example.dummy.Presentation.Home.Product

import androidx.annotation.DrawableRes
import com.example.dummy.R

data class Product(
    val name: String,
    val price: String,
    val description: String,
    @DrawableRes val image: Int,
    val isfavourite: Boolean = false,
    val inCart: Boolean = false
)

val products = listOf(
    Product(
        name = "organic Bananas",
        price = "$4.99",
        description = "7pcs, priceg",
        image = R.drawable.banana
    ),
    Product(
        name = "Red Apple",
        price = "$4.99",
        description = "7pcs, priceg",
        image = R.drawable.apple
    ),
    Product(
        name = "organic Bananas",
        price = "$4.99",
        description = "7pcs, priceg",
        image = R.drawable.banana
    ),
    Product(
        name = "Red Apple",
        price = "$4.99",
        description = "7pcs, priceg",
        image = R.drawable.apple
    )
)
