package com.example.legostoragemanager.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
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
        compossable(route = HomeDestination.route){
            HomeScreen(

            )
        }
    }
}