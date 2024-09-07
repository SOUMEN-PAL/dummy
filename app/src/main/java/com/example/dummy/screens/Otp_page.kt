package com.example.dummy.screens

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dummy.screens.pages.Pages
import com.example.dummy.viewModels.MainViewModel

@Composable
fun OTPScreen(modifier: Modifier = Modifier , navController: NavController , viewModel: MainViewModel , activity: Activity) {
    val phoneNumber = viewModel.phoneNumber
    val otp = viewModel.otp

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = phoneNumber.value,
            onValueChange = {newValue->
                phoneNumber.value = newValue.filter { it.isDigit() }.take(10)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(text = "Enter PhoneNumber")}
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            viewModel.getPhoneNumber(phoneNumber.value)
            viewModel.sendOtp(activity)

        }) {
            Text(text = "GetOTP")
        }

        if(viewModel.isVerificationCompleted.value){
            navController.navigate(Pages.SignUpPage.route)
        }

        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = otp.value,
            onValueChange = { newValue ->
                otp.value = newValue.filter { it.isDigit() }.take(6)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(text = "Enter OTP")}
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            viewModel.getOtp(otp.value)
            viewModel.verifyOTP {sucess->
                if(sucess){
                    navController.navigate(Pages.SignUpPage.route)
                }
                else{
                    Toast.makeText(activity , "error" , Toast.LENGTH_LONG).show()
                }
            }
        }) {
            Text(text = "Sign up")
        }

    }
}