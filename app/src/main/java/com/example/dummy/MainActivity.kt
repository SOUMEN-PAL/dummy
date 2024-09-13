package com.example.dummy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dummy.Presentation.Home.HomeScreen
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
                HomeScreen()
            }
        }
    }
}

