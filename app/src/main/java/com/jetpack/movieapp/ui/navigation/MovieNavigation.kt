package com.jetpack.movieapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jetpack.movieapp.ui.screens.DetailsScreen
import com.jetpack.movieapp.ui.screens.home.HomeScreen


const val NAV_ARG_MOVIE = "movie"

@Composable
fun MovieNavigation() {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name
    ) {

        composable(MovieScreens.HomeScreen.name) {
            //here we pass where this should lead us to
            HomeScreen(navController)
        }

        composable(
            MovieScreens.DetailsScreen.name + "/{movie}",
            arguments = listOf(navArgument(NAV_ARG_MOVIE) { type = NavType.StringType })
        ) { backStackEntry ->
            DetailsScreen(navController, backStackEntry.arguments?.getString(NAV_ARG_MOVIE))
        }

    }

}