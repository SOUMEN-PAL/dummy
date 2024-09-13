package com.example.dummy.Presentation.Home.Collections

import com.example.dummy.Presentation.Home.Product.Product
import com.example.dummy.Presentation.Home.Product.products

data class Collection(
    val name: String,
    val products: List<Product>
)

val categories = listOf(
    Collection(name = "Exclusive Offer", products = products),
    Collection(name = "Best Selling", products = products),
)
