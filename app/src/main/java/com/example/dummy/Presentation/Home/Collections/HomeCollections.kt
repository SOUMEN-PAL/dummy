package com.example.dummy.Presentation.Home.Collections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dummy.Presentation.Home.Product.Product
import com.example.dummy.Presentation.Home.Product.products
import com.example.dummy.R

@Composable
fun HomeCollections(
    collection: Collection
){
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = collection.name, fontSize = 24.sp)
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "See all", color = colorResource(id = R.color.maingreen))
                }
            }
            LazyRow() {
                items(products){product->
                    Product(product)
                }
            }
        }

    Spacer(modifier = Modifier.height(16.dp))
}

@Preview(showBackground = true)
@Composable
fun AdditionalCategoriesPreview(){
    HomeCollections(collection = collections[0])
}