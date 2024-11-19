package com.zobaer53.travelapp.ui.main_screen.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zobaer53.travelapp.R
import com.zobaer53.travelapp.ui.theme.DarkColorScheme

@Composable
fun PopularCategories() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        items(listOf("Flights", "Hotels", "Visa", "Buses")) { category ->
            CategoryItem(category)
        }
    }
}

@Composable
fun CategoryItem(category: String) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        color = DarkColorScheme.primary,
        modifier = Modifier.size(70.dp, 80.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            val iconResId = when (category) {
                "Flights" -> R.drawable.flights
                "Hotels" -> R.drawable.hotel
                "Visa" -> R.drawable.video
                "Buses" -> R.drawable.car
                else -> 0
            }

            Icon(
                painter = painterResource(id = iconResId),
                contentDescription = category,
                modifier = Modifier.size(25.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = category,
                color = Color.White,
                fontSize = 13.sp
            )
        }
    }
}