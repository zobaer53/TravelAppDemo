package com.zobaer53.travelapp.ui.details_screen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun ImageSlider(imageResIds: List<String>, align: Modifier) {
    val pagerState = rememberPagerState(initialPage = 0,0f) { imageResIds.size }
    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->

        AsyncImage(
            model = imageResIds[page],
            contentDescription = "Slider Image",
            modifier = Modifier.fillMaxSize()
                .clip(
                    RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomStart = 30.dp, // Adjust corner radius as needed
                        bottomEnd = 30.dp
                    )
                ),
            contentScale = ContentScale.FillBounds
        )
    }

    // Pager Indicator Overlay
    Row(
        modifier = align, // Aligns the indicator at the top
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(imageResIds.size) { page ->
            val color =
                if (pagerState.currentPage == page) Color(0xFFF88264) else Color.Gray
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .padding(2.dp)
                    .background(color = color, shape = RoundedCornerShape(50))
            )
        }
    }
}