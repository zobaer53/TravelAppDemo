package com.zobaer53.travelapp.ui.main_screen.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zobaer53.travelapp.ui.theme.SecondaryColorTA
import com.zobaer53.travelapp.ui.theme.TypographyTA

@Composable
fun SectionHeader(title: String, actionText: String? = null, onActionClick: (() -> Unit)? = null) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            color = Color.White,
            style = TypographyTA.titleMedium
            /*fontWeight = FontWeight.Bold,
            fontSize = 18.sp*/
        )
        if (actionText != null && onActionClick != null) {
            Text(
                text = actionText,
                color = SecondaryColorTA,
                style = TypographyTA.labelMedium,
                /*fontSize = 14.sp,*/
                modifier = Modifier.clickable(onClick = onActionClick)
            )
        }
    }
}