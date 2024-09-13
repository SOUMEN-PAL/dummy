package com.example.dummy.Presentation.Home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dummy.Presentation.Home.Banner.HomeBannerCategory
import com.example.dummy.Presentation.Home.Banner.banners
import com.example.dummy.Presentation.Home.Collections.AdditionalCategories
import com.example.dummy.Presentation.Home.Collections.categories

@Composable
fun HomeScreen(){
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        LocationSearchSection()
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)
        ){
            item{ HomeBannerCategory(banners = banners) }
            item{ AdditionalCategories(collection = categories[0]) }
            item{ AdditionalCategories(collection = categories[1]) }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}
