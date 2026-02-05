package com.example.legostoragemanager

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.legostoragemanager.ui.navigation.InventoryNavHost

@Composable
fun LegoStorageManagerApp(navController: NavHostController = rememberNavController()){
    InventoryNavHost(
        navController = navController,
        modifier = Modifier
    )
}