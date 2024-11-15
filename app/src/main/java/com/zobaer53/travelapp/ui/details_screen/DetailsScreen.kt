package com.zobaer53.travelapp.ui.details_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.zobaer53.travelapp.R
import com.zobaer53.travelapp.ui.details_screen.composables.GradientButton
import com.zobaer53.travelapp.ui.details_screen.composables.ImageSlider
import com.zobaer53.travelapp.ui.details_screen.composables.LocationText
import com.zobaer53.travelapp.ui.details_screen.composables.RatingText
import com.zobaer53.travelapp.ui.details_screen.composables.SectionHeader


// Main Screen Component for Mountain Safari Details
@Composable
fun MountainSafariCard(navController: NavHostController) {
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
                ImageSlider(imageResIds = listOf(R.drawable.safari_static, R.drawable.safari_static, R.drawable.safari_static))

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
                // Title Row
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Mountain Safari",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    RatingText(rating = "4.9")
                }

                // Location Row
                LocationText(location = "Kolkata, India")
                Spacer(modifier = Modifier.height(20.dp))

                // About Section
                SectionHeader(title = "About the trip 😊")
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "List of Inspiring Slogans a fresh coat for a fresh start meet the world make traveling fun explore the globe with a new sky, a new life let us help you find ...",
                    color = Color.White,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

              GradientButton()
            }
        }
    }
}
