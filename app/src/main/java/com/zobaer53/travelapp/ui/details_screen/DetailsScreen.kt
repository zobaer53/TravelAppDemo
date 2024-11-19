package com.zobaer53.travelapp.ui.details_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.zobaer53.travelapp.R
import com.zobaer53.travelapp.domain.model.LocationDetailsEntity
import com.zobaer53.travelapp.ui.details_screen.composables.GradientButton
import com.zobaer53.travelapp.ui.details_screen.composables.ImageSlider
import com.zobaer53.travelapp.ui.details_screen.composables.LocationText
import com.zobaer53.travelapp.ui.details_screen.composables.RatingText
import com.zobaer53.travelapp.ui.details_screen.composables.SectionHeader
import com.zobaer53.travelapp.ui.theme.TypographyTA


// Main Screen Component for Mountain Safari Details
@Composable
fun DetailsScreen(navController: NavHostController, locationDetails: LocationDetailsEntity) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)

            ) {

                // Using ImageSlider component with a list of images
                ImageSlider(
                    imageResIds = locationDetails.detailImage, Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .align(Alignment.BottomCenter))

                // Back Button
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(16.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = "Back",
                        tint = Color.Unspecified,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Content Section
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = locationDetails.propertyName,
                        color = Color.White,
                        style = TypographyTA.titleLarge,
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp)
                    )
                    RatingText(rating = locationDetails.rating.toString())
                }
                
                Spacer(modifier = Modifier.height(5.dp))

                // Location Row
                LocationText(location = locationDetails.location)
                Spacer(modifier = Modifier.height(20.dp))

                // About Section
                SectionHeader(title = "About the trip \uD83E\uDD29")
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = locationDetails.description,
                    color = Color.Gray,
                    style = TypographyTA.bodyMedium,
                    modifier = Modifier.padding(16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

              GradientButton(locationDetails)
            }
        }
    }
}
