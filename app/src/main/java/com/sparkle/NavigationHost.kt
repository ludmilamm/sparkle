package com.sparkle

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.sparkle.artworks.ArtworksNavigation
import com.sparkle.artworks.setupArtworkDetailNavigation
import com.sparkle.artworks.setupArtworksNavigation

@Composable
fun NavigationHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ArtworksNavigation.LIST_ROUTE) {
        setupArtworksNavigation(navController)
        setupArtworkDetailNavigation()
    }
}