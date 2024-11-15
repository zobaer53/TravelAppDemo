package com.zobaer53.travelapp.ui.recommend_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.zobaer53.travelapp.R
import com.zobaer53.travelapp.ui.main_screen.composables.RecommendedItem
import com.zobaer53.travelapp.ui.theme.DarkColorScheme
import com.zobaer53.travelapp.domain.model.LocationDetailsEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecommendedScreen(navController: NavHostController, locations: List<LocationDetailsEntity>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Recommended", modifier = Modifier.padding(start = 50.dp)) },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.back),
                            contentDescription = "Back",
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .size(32.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier
                    .padding(start = 16.dp)
            )
        },
        containerColor = DarkColorScheme.primary
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(innerPadding)
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(locations) { location ->
                RecommendedItem(location,navController)
            }
        }
    }
}