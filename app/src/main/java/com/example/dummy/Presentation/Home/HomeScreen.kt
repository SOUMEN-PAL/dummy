package com.example.dummy.Presentation.Home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dummy.Presentation.Home.Banner.HomeBanner
import com.example.dummy.Presentation.Home.Banner.banners
import com.example.dummy.Presentation.Home.BottomBar.BottomBar
//import com.example.dummy.Presentation.Home.Collections.HomeCollections
//import com.example.dummy.Presentation.Home.Collections.collections

@Composable
fun HomeScreen(){
    Scaffold(
        bottomBar = { BottomBar()}
    ) {pv->
        Column(
            Modifier
                .fillMaxSize()
                .padding(pv),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            LocationSection()
            SearchSection()

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ){
                item{ HomeBanner(banners = banners) }
//                item{ HomeCollections(collection = collections[0]) }
//                item{ HomeCollections(collection = collections[1]) }
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}
