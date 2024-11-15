package com.zobaer53.travelapp.ui.bottomnav

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.zobaer53.travelapp.R


@Composable
fun CustomBottomNavigationBar() {
    // Add margin and rounded corners to the Surface that wraps the BottomNavigationBar
    Surface(
        color = Color(0xFF2D303A),
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp) // Adjust margins
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Home Navigation Item
            NavigationBarItem(
                icon = {
                    Icon(
                        painterResource(id = R.drawable.home), contentDescription = "Home",
                        modifier = Modifier.size(24.dp),
                        tint = Color.Unspecified
                    )
                },
                selected = false,
                onClick = { /* TODO */ }
            )

            // Bookmark Navigation Item
            NavigationBarItem(
                icon = {
                    Icon(
                        painterResource(id = R.drawable.bookmark_icon),
                        contentDescription = "Bookmark",
                        modifier = Modifier.size(24.dp),
                        tint = Color.Unspecified
                    )
                },
                selected = false,
                onClick = { /* TODO */ }
            )

            // Notifications Navigation Item
            NavigationBarItem(
                icon = {
                    Icon(
                        painterResource(id = R.drawable.notification),
                        contentDescription = "Notifications",
                        modifier = Modifier.size(24.dp),
                        tint = Color.Unspecified
                    )
                },
                selected = false,
                onClick = { /* TODO */ }
            )

            // Profile Navigation Item
            NavigationBarItem(
                icon = {
                    Icon(
                        painterResource(id = R.drawable.profile_icon),
                        contentDescription = "Profile",
                        modifier = Modifier.size(24.dp),
                        tint = Color.Unspecified
                    )
                },
                selected = false,
                onClick = { /* TODO */ }
            )
        }
    }
}
