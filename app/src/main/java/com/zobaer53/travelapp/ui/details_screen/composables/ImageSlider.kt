package com.zobaer53.travelapp.ui.details_screen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun ImageSlider(imageResIds: List<Int>) {
    val pagerState = rememberPagerState(initialPage = 0,0f) { imageResIds.size }
    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        val imagePainter: Painter = painterResource(id = imageResIds[page])
        Image(
            painter = imagePainter,
            contentDescription = "Slider Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}