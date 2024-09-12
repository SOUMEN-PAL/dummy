package com.example.dummy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dummy.Presentation.SignInScreen
import com.example.dummy.screens.Navigation
import com.example.dummy.ui.theme.DummyTheme
import com.example.dummy.viewModels.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var viewModel:MainViewModel = viewModel()
            DummyTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Navigation(viewModel = viewModel, activity = this , modifier = Modifier.padding(innerPadding))
//                }
                SignInScreen()
            }
        }
    }
}

