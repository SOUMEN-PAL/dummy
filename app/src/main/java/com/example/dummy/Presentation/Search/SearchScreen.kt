package com.example.dummy.Presentation.Search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dummy.Presentation.Explore.Category
import com.example.dummy.Presentation.Explore.TextSection
import com.example.dummy.Presentation.Explore.categories
import com.example.dummy.Presentation.Home.BottomBar.BottomBar
import com.example.dummy.Presentation.Home.Product.Product
import com.example.dummy.Presentation.Home.Product.products
import com.example.dummy.Presentation.Home.SearchSection

@Composable
fun SearchScreen(){
    Scaffold(
        bottomBar = { BottomBar() }
    ) {pv->
        Column(
            Modifier
                .fillMaxSize()
                .padding(pv),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            SearchSectionRow()

            LazyVerticalGrid(columns = GridCells.Fixed(2),
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                repeat(5){
                    items(products){ product->
                        Product(product = product, modifier = Modifier.padding(8.dp))
                    }
                }
            }

        }
    }
}

@Preview
@Composable
fun SearchScreenPreview(){
    SearchScreen()
}