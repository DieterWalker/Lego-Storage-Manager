package com.example.legostoragemanager.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
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
        topBar = {
            HomeTopBar(
                modifier = modifier
            )
        }
    ) { innerPadding ->
        HomeBody(
            navigateToPiecesScreen = navigateToPiecesScreen,
            navigateToMinifigureScreen = navigateToMinifigureScreen,
            modifier = modifier,
            contentPadding = innerPadding,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier
){
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.fillMaxWidth()
            ){
                Text(
                    text = stringResource(HomeDestination.titleRes),
                    style = MaterialTheme.typography.headlineMedium
                )
            }

        }
    )

}

@Composable
fun HomeBody(
    navigateToPiecesScreen: () -> Unit,
    navigateToMinifigureScreen: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(all = 0.dp),
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
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
            onClick = navigateToMinifigureScreen
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