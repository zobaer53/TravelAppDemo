package com.zobaer53.travelapp.ui.main_screen.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.zobaer53.travelapp.R
import com.zobaer53.travelapp.ui.theme.DarkColorScheme

@Composable
fun SearchBarMain() {
    OutlinedTextField(
        value = "",
        onValueChange = { /* TODO */ },
        placeholder = { Text("Search", color = DarkColorScheme.primary) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 16.dp)
            .clip(RoundedCornerShape(15.dp)),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Gray,
            unfocusedTextColor = Color.Gray,
            focusedLabelColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = Color.White,
        ),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = Color.Gray
            )
        },
        shape = RoundedCornerShape(15.dp)
    )
}