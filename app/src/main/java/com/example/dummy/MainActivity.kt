package com.example.dummy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.dummy.Farmer.Home.FarmerHomeScreen
import com.example.dummy.Farmer.Home.TransactionData
import com.example.dummy.Farmer.NewOrder.AddItemSection
import com.example.dummy.Farmer.NewOrder.OrderScreen
import com.example.dummy.Farmer.Transaction.TransactionScreen
import com.example.dummy.Presentation.Explore.CategoryData
import com.example.dummy.Presentation.Explore.categories
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
            val transaction = TransactionData()
            DummyTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Navigation(viewModel = viewModel, activity = this , modifier = Modifier.padding(innerPadding))
//                }
                OrderScreen()
            }
        }
    }
}

