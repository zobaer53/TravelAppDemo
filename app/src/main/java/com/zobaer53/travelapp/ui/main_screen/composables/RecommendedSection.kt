package com.zobaer53.travelapp.ui.main_screen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.zobaer53.travelapp.R
import com.zobaer53.travelapp.ui.recommend_screen.Location
import com.zobaer53.travelapp.ui.theme.TypographyTA


@Composable
fun RecommendedSection(navController: NavHostController) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
        val locations = listOf(
            Location("Mountain Safari", "India", R.drawable.safari_static),
            Location("Beach Side", "Hawaii", R.drawable.safari_static),
            Location("Safari Park", "Thailand", R.drawable.safari_static)
        )
        items(locations) { location ->
            RecommendedItem(location, navController)
        }
    }
}

@Composable
fun RecommendedItem(destination: Location, navController: NavHostController) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        color = Color.DarkGray,
        modifier = Modifier
            .size(210.dp, 250.dp)
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable { navController.navigate("mountainSafari") }
        ) {
            Image(
                painter = painterResource(id = R.drawable.safari_static),
                contentDescription = destination.title,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    RoundedIconButton(iconRes = R.drawable.bookmark, onClick = { /* TODO */ })
                }
                Column {
                    Text(
                        text = destination.title,
                        color = Color.White,
                        style = TypographyTA.titleMedium
                    )
                    LocationRow(text = destination.location)
                }
            }
        }
    }
}
