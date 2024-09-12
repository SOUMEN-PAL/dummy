package com.example.dummy.Presentation

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dummy.R


@Composable
fun SignInScreen(){

    var number by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.4f),
            contentAlignment = Alignment.Center
        ){
            Image(painter = painterResource(id = R.drawable.signin),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp)
                .padding(top = 50.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = "Get your groceries\n" + "with nectar",
                fontSize = 26.sp
            )

            TextField(value = number, onValueChange = {number = it},
                leadingIcon = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Image(painter = painterResource(id = R.drawable.india1), contentDescription = null,
                                Modifier.size(width = 31.dp, height = 22.dp)
                            )
                            Text(text = "+91")
                        }

                    },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White
                )
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 32.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(text = "Or connect with social media")
                Spacer(modifier = Modifier.width(32.dp))
                Button(onClick = { /*TODO*/ },
                    modifier = Modifier.size(width = 353.dp, height = 60.dp),
                    shape = RoundedCornerShape(19.dp),
                    colors = ButtonColors(
                        containerColor = colorResource(id = R.color.googleButton),
                        contentColor = Color.White,
                        disabledContainerColor = colorResource(id = R.color.googleButton),
                        disabledContentColor = Color.White
                    )
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Image(painter = painterResource(id = R.drawable.google), contentDescription = null,
                            Modifier
                                .size(20.dp)
                                .weight(1f))
//                        Spacer(modifier = Modifier.width(40.dp))
                        Text(text = "Continue with Google", Modifier.weight(2.5f))
                    }

                }

                Button(onClick = { /*TODO*/ },
                    modifier = Modifier.size(width = 353.dp, height = 60.dp),
                    shape = RoundedCornerShape(19.dp),
                    colors = ButtonColors(
                        containerColor = colorResource(id = R.color.facebookButton),
                        contentColor = Color.White,
                        disabledContainerColor = colorResource(id = R.color.facebookButton),
                        disabledContentColor = Color.White
                    )
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Image(painter = painterResource(id = R.drawable.facebook), contentDescription = null,
                            Modifier
                                .size(20.dp)
                                .weight(1f))
                        Text(text = "Continue with facebook", Modifier.weight(2.5f))
                    }

                }
            }




        }

    }
}


@Preview(showBackground = true)
@Composable
fun SignInScreenPreview(){
    SignInScreen()
}