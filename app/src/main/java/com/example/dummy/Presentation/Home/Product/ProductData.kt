package com.example.dummy.Presentation.Home.Product

import androidx.annotation.DrawableRes
import com.example.dummy.R

interface Product {
    val name: String
    val price: String
    val description: String
    val details : String
    val imageName : String
    val quantity: Int
}

data class ProductDataItems(
    override val name: String = "",
    override val price: String = "",
    override val description: String = "",
    override val details: String = "",
    override val imageName: String = "",
    override val quantity: Int = 0,
    @DrawableRes val image: Int,
) : Product

data class ProductDataUser(
    override val name: String,
    override val price: String,
    override val description: String,
    override val details : String = "",
    override val imageName: String = "",
    override val quantity: Int = 0,
    val isfavourite: Boolean = false,
    val inCart: Boolean = false
) : Product

val products = listOf(
    ProductDataItems(
        name = "organic Bananas",
        price = "$4.99",
        description = "7pcs, priceg",
        image = R.drawable.banana
    ),
    ProductDataItems(
        name = "Red Apple",
        price = "$4.99",
        description = "7pcs, priceg",
        image = R.drawable.apple
    ),
    ProductDataItems(
        name = "organic Bananas",
        price = "$4.99",
        description = "7pcs, priceg",
        image = R.drawable.banana
    ),
    ProductDataItems(
        name = "Red Apple",
        price = "$4.99",
        description = "7pcs, priceg",
        image = R.drawable.apple
    )
)

