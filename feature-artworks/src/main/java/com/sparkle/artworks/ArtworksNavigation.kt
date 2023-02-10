package com.sparkle.artworks

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.sparkle.artworks.ArtworksNavigation.DETAIL_ID_ROUTE
import com.sparkle.artworks.ArtworksNavigation.DETAIL_ID_ROUTE_PLACEHOLDER
import com.sparkle.artworks.ArtworksNavigation.DETAIL_ROUTE
import com.sparkle.artworks.detail.view.ArtworkDetailScreen
import com.sparkle.artworks.list.view.ArtworksScreen

object ArtworksNavigation {
    const val DETAIL_ID_ROUTE = "artworkId"
    const val DETAIL_ID_ROUTE_PLACEHOLDER = "{$DETAIL_ID_ROUTE}"

    const val LIST_ROUTE = "artworks"
    const val DETAIL_ROUTE = "artworks/$DETAIL_ID_ROUTE_PLACEHOLDER"
}

fun NavGraphBuilder.setupArtworksNavigation(navController: NavHostController) {
    composable(ArtworksNavigation.LIST_ROUTE) {
        ArtworksScreen() {
            navController.navigate(DETAIL_ROUTE.replace(DETAIL_ID_ROUTE_PLACEHOLDER, it.toString()))
        }
    }
}

fun NavGraphBuilder.setupArtworkDetailNavigation() {
    composable(
        route = DETAIL_ROUTE,
        arguments = listOf(navArgument(DETAIL_ID_ROUTE) { type = NavType.LongType })
    ) { backStackEntry ->
        val artworkId = backStackEntry.arguments?.getLong(DETAIL_ID_ROUTE)

        artworkId?.let { ArtworkDetailScreen(it) }
    }
}