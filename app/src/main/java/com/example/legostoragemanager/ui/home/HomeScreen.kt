package com.example.legostoragemanager.ui.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import com.example.legostoragemanager.R
import com.example.legostoragemanager.ui.navigation.NavigationDestination

object HomeDestination : NavigationDestination{
    override val route = "home"
    override val titleRes = R.string.app_name
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
){

}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}