package com.example.dummy.Presentation.Home.Banner

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun HomeBannerCategory(
    banners: List<Banner>
){
    val pagerState = rememberPagerState(initialPage = 0) {
        banners.size
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ){
        Spacer(modifier = Modifier.height(16.dp))
        HorizontalPager(state = pagerState, modifier = Modifier.fillMaxWidth()) { index ->

            Homebanner(banner = banners[index])

        }
        Spacer(modifier = Modifier.height(16.dp))
    }


}


@Preview(showBackground = true)
@Composable
fun HomeBannercategoryPreview(){
    HomeBannerCategory(banners = banners)
}