package com.zobaer53.travelapp.ui.details_screen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zobaer53.travelapp.R
import com.zobaer53.travelapp.ui.theme.TypographyTA

@Composable
fun RatingText(rating: String, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(end = 16.dp)
    ) {
        Image(
            painter = if(rating.toDouble() == 5.0) painterResource(id = R.drawable.star_rate_14) else painterResource(id = R.drawable.star_half_14 ),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = rating,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            style = TypographyTA.labelMedium
        )
    }
}
