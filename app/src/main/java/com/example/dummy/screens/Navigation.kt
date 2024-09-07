package com.example.dummy.screens

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dummy.screens.pages.Pages
import com.example.dummy.viewModels.MainViewModel

@Composable
fun Navigation(modifier: Modifier = Modifier , viewModel: MainViewModel , activity: Activity) {
    val navController = rememberNavController()
    var showHomeScreen by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        showHomeScreen = viewModel.isUserLoggedIn()
    }

    NavHost(navController = navController, startDestination = if (showHomeScreen) Pages.DataPage.route else Pages.OTPPage.route){
        composable(route = Pages.OTPPage.route){
            OTPScreen(navController = navController , viewModel = viewModel , activity = activity)
        }
        composable(route = Pages.DataPage.route){
            DataScreen(viewModel = viewModel , navController = navController)
        }
        composable(route = Pages.SignUpPage.route){
            SignUpScreen(viewModel = viewModel , navController = navController)
        }
        composable(route = Pages.LoginPage.route){
            LoginScreen(viewModel = viewModel, navController = navController)
        }
    }
}
