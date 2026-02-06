package com.example.legostoragemanager.ui.navigation

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.legostoragemanager.ui.home.HomeDestination
import com.example.legostoragemanager.ui.home.HomeScreen
import com.example.legostoragemanager.ui.pieceSeller.PiecesSellerDestination
import com.example.legostoragemanager.ui.piecesManager.PiecesManagerDestination
import com.example.legostoragemanager.ui.piecesManager.PiecesManagerScreen

/**
* Cung cấp biểu đồ điều hướng cho ứng dụng
* */

@Composable
fun InventoryNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = modifier
    ) {
        /** Màn hình chính */
        composable(route = HomeDestination.route){
            HomeScreen(
                onNavigateToManagerScreen = {
                    navController.navigate(route = PiecesManagerDestination.route)
                },
                onNavigateToSellerScreen = {
                    navController.navigate(route = PiecesSellerDestination.route)
//                    Toast.makeText(
//                        context,
//                        "This feature is under development",
//                        Toast.LENGTH_SHORT
//                    ).show()
                },
                modifier = modifier.fillMaxSize(),
            )
        }

        /** Màn hình quản lý gạch Lego */
        composable (route = PiecesManagerDestination.route){
            PiecesManagerScreen(
                modifier = modifier.fillMaxSize(),
                onBack = {
                    navController.popBackStack()
                },

            )
        }

        /** Màn hình bán gạch Lego */
        composable (route = PiecesSellerDestination.route){
            PiecesManagerScreen(
                modifier = modifier.fillMaxSize(),
                onBack = {
                    navController.popBackStack()
                },

                )
        }
    }
}