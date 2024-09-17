package com.example.dummy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.dummy.Favourites.FavouriteItem
import com.example.dummy.Favourites.FavouritesScreen
import com.example.dummy.Presentation.Home.Product.ProductDataItems
import com.example.dummy.Presentation.MyCart.CartItem
import com.example.dummy.Presentation.MyCart.MyCartScreen
//import com.example.dummy.Presentation.Home.HomeScreen
//import com.example.dummy.Presentation.Search.SearchScreen
import com.example.dummy.ui.theme.DummyTheme
//import com.example.dummy.viewModels.CustomerHomeScreenViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            val navController: NavController = rememberNavController()
//            var viewModel:CustomerHomeScreenViewModel = viewModel()
            var product = ProductDataItems(
                name = "organic Bananas",
                price = "$4.99",
                description = "7pcs, priceg",
                image = R.drawable.banana
            )
            DummyTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Navigation(viewModel = viewModel, activity = this , modifier = Modifier.padding(innerPadding))
//                }
                FavouritesScreen()

            }
        }
    }
}

