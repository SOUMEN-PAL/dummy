package com.example.dummy.Presentation.MyCart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dummy.Presentation.Explore.TextSection
import com.example.dummy.Presentation.Home.BottomBar.BottomBar
import com.example.dummy.Presentation.Home.Product.ProductDataItems
import com.example.dummy.R
import com.example.dummy.viewModels.CustomerHomeScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCartScreen(
) {

    Scaffold(
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Button(
                    onClick = {

                    },
                    modifier = Modifier.size(width = 353.dp, height = 60.dp),
                    shape = RoundedCornerShape(19.dp),
                    colors = ButtonColors(
                        containerColor = colorResource(id = R.color.maingreen),
                        contentColor = Color.White,
                        disabledContainerColor = colorResource(id = R.color.maingreen),
                        disabledContentColor = Color.White
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(text = "Go to CheckOut" ,
                            modifier = Modifier.weight(1f), textAlign = TextAlign.Center)


                        Box(modifier = Modifier
                            .wrapContentSize(Alignment.CenterEnd)
                            .background(
                                color = colorResource(id = R.color.grey),
                                shape = RoundedCornerShape(4.dp)
                            )
                            .padding(2.dp)

                            ){
                            Column(
                            ) {
                                //TODO: items ka price ka sum
                                Text(text = "₹250")

                            }


                        }
                    }

                }

                BottomBar()
            }
        },
        topBar = { TopAppBar(title = { TextSection(text = "My Cart") }) },
    ) { pv ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(pv),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                repeat(20) {
                    item {
                        CartItem(
                            productData = ProductDataItems(
                                name = "organic Bananas",
                                price = "$4.99",
                                description = "7pcs, priceg",
                                image = R.drawable.banana
                            ),
                            onClick = {
                                //TODO: navigate to product details page
                            }
                        )

                    }

                }
            }

        }
    }
}