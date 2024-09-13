package com.example.dummy.Presentation.Explore

import androidx.annotation.DrawableRes
import androidx.compose.ui.res.colorResource
import com.example.dummy.R

data class CategoryData(
    @DrawableRes val image: Int,
    val name: String,
    val color: Int,
    val bordercolor: Int
)

val categories = listOf(
    CategoryData(
        image = R.drawable.fruitveg,
        name = "Fresh Fruits\n" +
                "& Vegetable",
        color = R.color.lightgreen,
        bordercolor = R.color.bordergreen
    ),
    CategoryData(
        image = R.drawable.meatfish,
        name = "Meat & Fish",
        color = R.color.lightred,
        bordercolor = R.color.borderred
    ),
    CategoryData(
        image = R.drawable.dairyeggs,
        name = "Dairy & Eggs",
        color = R.color.lightyellow,
        bordercolor = R.color.borderellow
    )

)
