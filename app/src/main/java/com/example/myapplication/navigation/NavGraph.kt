package com.example.myapplication.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.screen.AnimatedSplashScreen
import com.example.myapplication.screen.Home

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            AnimatedSplashScreen(navHostController = navController)
        }
        composable(route = Screen.Home.route) {
            Home()
        }
    }
}