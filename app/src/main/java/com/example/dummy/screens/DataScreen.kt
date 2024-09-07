package com.example.dummy.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dummy.screens.pages.Pages
import com.example.dummy.viewModels.MainViewModel

@Composable
fun DataScreen(modifier: Modifier = Modifier , viewModel: MainViewModel , navController: NavController) {
    val email = viewModel.email
    val number = viewModel.phoneNumber
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = email.value)
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = number.value)
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = {
            viewModel.signOut()
            navController.navigate(Pages.LoginPage.route)
        }) {
            Text(text = "Sign Out")
        }
    }
}