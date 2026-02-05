package com.example.legostoragemanager.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.legostoragemanager.ui.home.HomeDestination
import com.example.legostoragemanager.ui.home.HomeScreen

/**
* Cung cấp biểu đồ điều hướng cho ứng dụng
* */

@Composable
fun InventoryNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = modifier
    ) {
        composable(route = HomeDestination.route){
            HomeScreen(
                navigateToPiecesScreen = {},
                navigateToMinifigureScreen = {},
                modifier = modifier.fillMaxSize(),
            )
        }
    }
}