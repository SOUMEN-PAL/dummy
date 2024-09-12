package com.example.dummy.Presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.VectorProperty
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dummy.R

@Composable
fun onBordingScreen(){
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Image(painter = painterResource(id = R.drawable.onboarding),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 90.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.trolley2),
                contentDescription = null,
                modifier = Modifier
                    .size(height = 54.dp, width = 56.dp)
            )
            Text(text = "Welcome", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 48.sp)
            Text(text = "to our store", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 48.sp)
            Text(text = "Get your groceries in as fast as one hour", color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.size(width = 353.dp, height = 60.dp),
                shape = RoundedCornerShape(19.dp),
                colors = ButtonColors(
                    containerColor = colorResource(id = R.color.onboardbutton),
                    contentColor = Color.White,
                    disabledContainerColor = colorResource(id = R.color.onboardbutton),
                    disabledContentColor = Color.White
                )
            ) {
                Text(text = "Get Started")
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun onBordingScreenPreview(){
    onBordingScreen()
}