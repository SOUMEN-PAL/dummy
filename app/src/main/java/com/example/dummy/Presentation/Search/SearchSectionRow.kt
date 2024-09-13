package com.example.dummy.Presentation.Search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dummy.Presentation.Home.MySearchBar
import com.example.dummy.R


@Composable
fun SearchSectionRow() {
    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            MySearchBar(
                query = text,
                onQueryChange = { text = it },
                onSearch = {//callback function
                    //search operation to perform
                    active = false
                },
                active = active,
                onActiveChange = { active = it },
                modifier = Modifier.heightIn(max = 64.dp).weight(1f)
            )
           IconButton(onClick = { /*TODO*/ }
               ) {
               Icon(painter = painterResource(id = R.drawable.filter),
                   contentDescription = null,
                   modifier = Modifier.size(30.dp).padding(top = 8.dp)
                   )
           }

        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}


@Preview(showBackground = true, device = Devices.PIXEL_7)
@Composable
fun SearchSectionPreview() {
    SearchSectionRow()
}