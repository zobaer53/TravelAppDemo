package com.zobaer53.travelapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.zobaer53.travelapp.domain.model.LocationDetailsEntity
import com.zobaer53.travelapp.ui.details_screen.DetailsScreen
import com.zobaer53.travelapp.ui.main_screen.MainScreen
import com.zobaer53.travelapp.ui.recommend_screen.RecommendedScreen
import com.zobaer53.travelapp.ui.theme.TravelAppTheme
import dagger.hilt.android.AndroidEntryPoint
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("StateFlowValueCalledInComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            TravelAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box {
                        Image(
                            painter = painterResource(id = R.drawable.background),
                            contentDescription = "Background Image",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        val mainViewModel : MainViewModel = viewModel()

                        val navController = rememberNavController()
                        NavHost(
                            navController = navController,
                            startDestination = "home"
                        ) {
                            composable("home") { MainScreen(navController,mainViewModel) }
                            composable(
                                "detailsScreen/{locationDetails}",
                                arguments = listOf(navArgument("locationDetails") { type = NavType.StringType })
                            ) { backStackEntry ->
                                val encodedJson = backStackEntry.arguments?.getString("locationDetails")
                                val decodedJson = URLDecoder.decode(encodedJson, StandardCharsets.UTF_8.toString()) // Decode the string
                                val locationDetails = Gson().fromJson(decodedJson, LocationDetailsEntity::class.java)
                                DetailsScreen(navController, locationDetails)
                            }
                            composable("recommended") { RecommendedScreen(navController,mainViewModel.uiState.value.data) }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TravelAppTheme {
        Greeting("Android")
    }
}