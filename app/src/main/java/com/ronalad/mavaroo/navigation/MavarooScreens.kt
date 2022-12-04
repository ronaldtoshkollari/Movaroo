package com.ronalad.mavaroo.navigation

sealed class MavarooScreens(val route: String) {
    object PopularMoviesScreen : MavarooScreens("popular_movies_screen")
    object TitleDetailsScreen : MavarooScreens("title_details_screen")
}
