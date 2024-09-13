package com.example.dummy.Presentation.Home

data class Category(
    val name: String,
    val items: List<Item>
)

val categories = listOf(
    Category(name = "Exclusive Offer", items = items),
    Category(name = "Best Selling", items = items),
)
