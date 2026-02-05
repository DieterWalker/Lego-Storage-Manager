package com.example.legostoragemanager.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.legostoragemanager.R
import com.example.legostoragemanager.ui.navigation.NavigationDestination

object HomeDestination : NavigationDestination{
    override val route = "home"
    override val titleRes = R.string.app_name
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToPiecesScreen: () -> Unit,
    navigateToMinifigureScreen: () -> Unit,
    modifier: Modifier = Modifier
){
    Scaffold(

    ) { innerPadding ->
        HomeBody(
            navigateToPiecesScreen = navigateToPiecesScreen,
            navigateToMinifigureScreen = navigateToMinifigureScreen,
            modifier = modifier,
            contentPadding = innerPadding,
        )
    }
}

@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier
){

}
@Composable
fun HomeBody(
    navigateToPiecesScreen: () -> Unit,
    navigateToMinifigureScreen: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(all = 0.dp),
){
    Column(
        modifier = modifier
    ) {
        Text(
            text = "Welcome Back!"
        )
        Button(
            onClick = navigateToPiecesScreen,
        ) {
            Text("Brick")
        }

        Button(
            onClick = navigateToPiecesScreen
        ) {
            Text("Minifigure")
        }
    }

}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(
        navigateToPiecesScreen = {} ,
        navigateToMinifigureScreen = {},
        modifier = Modifier.fillMaxSize(),
    )
}