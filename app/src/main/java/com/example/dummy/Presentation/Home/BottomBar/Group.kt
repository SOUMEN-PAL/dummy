package com.example.dummy.Presentation.Home.BottomBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.data.Group
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dummy.R

@Composable
fun Group(
    group: BottomBarData,
    isClicked: Boolean,
    onGroupClick: () -> Unit
){

    IconButton(onClick = { onGroupClick() },
        modifier = Modifier
            .width(70.dp)
        ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if(isClicked){
                Image(painter = painterResource(id = group.clickedicon),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Text(text = group.name, fontSize = 10.sp, color = colorResource(id = R.color.maingreen))
            }else{
                Image(painter = painterResource(id = group.icon),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Text(text = group.name, fontSize = 10.sp)
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GroupPreview(){
    Group(group = groups[1], false, {})
}
