package com.ronalad.mavaroo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ronalad.mavaroo.popular_movies.presentation.popular_movies.composables.PopularMoviesScreen
import com.ronalad.mavaroo.title_details.presentation.composables.TitleDetailsScreen

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MavarooScreens.PopularMoviesScreen.route
    ) {

        composable(route = MavarooScreens.PopularMoviesScreen.route) {
            PopularMoviesScreen(navController = navController)
        }

        composable(
            route = MavarooScreens.TitleDetailsScreen.route + "/{titleId}",
            arguments = listOf(navArgument(name = "titleId") {
                type = NavType.StringType
            })
        ) { entry ->
            TitleDetailsScreen(navController = navController, entry.arguments?.getString("titleId"))
        }
    }

}