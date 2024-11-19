package com.zobaer53.travelapp.ui.main_screen.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.google.gson.Gson
import com.zobaer53.travelapp.R
import com.zobaer53.travelapp.domain.model.LocationDetailsEntity
import com.zobaer53.travelapp.ui.theme.TypographyTA
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


@Composable
fun RecommendedSection(navController: NavHostController, locations: List<LocationDetailsEntity>) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
        itemsIndexed(locations) { index, location ->
            RecommendedItem(location, navController, showBookmark = index == 0)
        }
    }
}

@Composable
fun RecommendedItem(destination: LocationDetailsEntity, navController: NavHostController, showBookmark: Boolean) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        color = Color.DarkGray,
        modifier = Modifier
            .size(210.dp, 230.dp)
            .padding(5.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    val destinationJson = URLEncoder.encode(
                        Gson().toJson(destination),
                        StandardCharsets.UTF_8.toString()
                    )
                    navController.navigate("detailsScreen/$destinationJson")
                }
        ) {
            AsyncImage(
                model = destination.heroImage,
                contentDescription = destination.propertyName,
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
                if (showBookmark) { // Only show for the first item
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        RoundedIconButton(iconRes = R.drawable.bookmark, onClick = { /* TODO */ })
                    }

                }
                else {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        RoundedIconButton(iconRes = R.drawable.bookmark_icon, onClick = { /* TODO */ })
                    }
                }
                Column {
                    Text(
                        text = destination.propertyName,
                        color = Color.White,
                        style = TypographyTA.titleSmall,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    LocationRow(text = destination.location)
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}

