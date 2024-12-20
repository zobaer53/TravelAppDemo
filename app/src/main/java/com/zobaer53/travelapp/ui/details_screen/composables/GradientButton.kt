package com.zobaer53.travelapp.ui.details_screen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zobaer53.travelapp.domain.model.LocationDetailsEntity
import com.zobaer53.travelapp.ui.theme.SecondaryColorTA
import com.zobaer53.travelapp.ui.theme.LightSecondaryColorTA
import com.zobaer53.travelapp.ui.theme.TypographyTA
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.roundToInt

// Reusable GradientButton Component
@Composable
fun GradientButton(locationDetails: LocationDetailsEntity) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // Other content above...

            // Spacer to push content to the bottom
            Spacer(modifier = Modifier.weight(1f))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontSize = 12.sp)) {
                                append(if (locationDetails.currency == "USD") "$" else locationDetails.currency)
                            }
                            withStyle(style = SpanStyle(fontSize = 16.sp)) {
                                val formattedFare = NumberFormat.getNumberInstance(Locale.US).format(locationDetails.fare.roundToInt())
                                append(" $formattedFare")
                            }
                        },
                        color = Color.White,
                        style = TypographyTA.titleMedium
                    )
                    Spacer(modifier = Modifier.width(4.dp)) // Space between price and text
                    Text(
                        text = " /${locationDetails.fareUnit.uppercase(Locale.ROOT)}",
                        color = Color.Gray,
                        style = TypographyTA.bodySmall
                    )
                }

                Button(
                    onClick = { /* TODO: Handle click */ },
                    shape = RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent // Make button background transparent
                    ),

                    ) {
                    // Gradient background in Box
                    Box(
                        modifier = Modifier
                            .height(55.dp)
                            .width(160.dp)
                            .background(
                                brush = Brush.linearGradient(
                                    colors = listOf(
                                        SecondaryColorTA,
                                        LightSecondaryColorTA,
                                    ) // Adjust colors as needed
                                ),
                                shape = RoundedCornerShape(15.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = if(locationDetails.isAvailable)"Book Now" else "Not Available",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            style = TypographyTA.titleMedium
                        )
                    }
                }
            }
        }
    }
}