package com.example.dummy.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dummy.screens.pages.Pages
import com.example.dummy.viewModels.MainViewModel

@Composable
fun LoginScreen(modifier: Modifier = Modifier , viewModel: MainViewModel , navController: NavController) {
    val email = viewModel.email
    val password = viewModel.password
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        OutlinedTextField(value = email.value, onValueChange = {
            email.value = it
        })
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(value = password.value, onValueChange = {
            password.value = it
        })
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = {
            viewModel.getEmail(email.value)
            viewModel.getPassword(password.value)
            viewModel.login {sucess->
                if(sucess){
                    navController.navigate(Pages.DataPage.route)
                }
                else{
                    Log.e("error" , "Sign up error")
                }
            }
        }) {
            Text(text = "Log in")
        }
    }
}