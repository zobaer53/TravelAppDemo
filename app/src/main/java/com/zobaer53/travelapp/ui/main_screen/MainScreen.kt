package com.zobaer53.travelapp.ui.main_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.zobaer53.travelapp.MainViewModel
import com.zobaer53.travelapp.ui.bottomnav.CustomBottomNavigationBar
import com.zobaer53.travelapp.ui.main_screen.composables.PopularCategories
import com.zobaer53.travelapp.ui.main_screen.composables.RecommendedSection
import com.zobaer53.travelapp.ui.main_screen.composables.SearchBarMain
import com.zobaer53.travelapp.ui.main_screen.composables.SectionHeader
import com.zobaer53.travelapp.ui.main_screen.composables.TopBar
import kotlinx.coroutines.flow.collectLatest

@Composable
fun MainScreen(navController: NavHostController, mainViewModel: MainViewModel) {
    val uiState by mainViewModel.uiState.collectAsState()
    Scaffold(
        bottomBar = { CustomBottomNavigationBar() },
        containerColor = Color.Transparent
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            TopBar()
            Spacer(modifier = Modifier.height(30.dp))
            SearchBarMain()
            Spacer(modifier = Modifier.height(30.dp))
            SectionHeader(title = "Popular Categories")
            PopularCategories()
            SectionHeader(title = "Recommended", actionText = "See All") {
                navController.navigate("recommended")
            }

            // Displaying recommended section only if data exists
            if (uiState.data.isNotEmpty()) {
                RecommendedSection(navController, uiState.data)
            }
        }
    }
}
















