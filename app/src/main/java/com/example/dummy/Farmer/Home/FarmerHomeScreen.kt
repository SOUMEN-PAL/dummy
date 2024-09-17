package com.example.dummy.Farmer.Home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.dummy.Farmer.BottomSection
import com.example.dummy.Farmer.TopBarSection
import com.example.dummy.Farmer.TransactionSection

@Composable
fun FarmerHomeScreen(){
    Scaffold(
        bottomBar = { BottomSection() }
    ){pv->
        Column(
            Modifier
                .fillMaxSize()
                .padding(pv),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            TopBarSection("Dashboard")
            CardSection()
            GraphSection()
            TransactionSection("Recent Transactions")
        }

    }
}