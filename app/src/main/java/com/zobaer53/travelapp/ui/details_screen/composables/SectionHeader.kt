package com.zobaer53.travelapp.ui.details_screen.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zobaer53.travelapp.ui.theme.TypographyTA

// Reusable SectionHeader Component
@Composable
fun SectionHeader(title: String) {
    Text(
        text = title,
        color = Color.White,
        style = TypographyTA.titleMedium,
        modifier = Modifier.padding(start = 16.dp)
    )
}