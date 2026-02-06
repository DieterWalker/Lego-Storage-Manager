package com.example.legostoragemanager.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.legostoragemanager.R
import com.example.legostoragemanager.ui.navigation.NavigationDestination
import com.example.legostoragemanager.ui.theme.Shapes

object HomeDestination : NavigationDestination{
    override val route = "home"
    override val titleRes = R.string.app_name
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToManagerScreen: () -> Unit,
    onNavigateToSellerScreen: () -> Unit,
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
            onNavigateToManagerScreen = onNavigateToManagerScreen,
            onNavigateToSellerScreen = onNavigateToSellerScreen,
            modifier = modifier,
            contentPadding = innerPadding,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeTopBar(
    modifier: Modifier = Modifier
){
    TopAppBar(
        title = {
            Row(
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
private fun HomeBody(
    onNavigateToManagerScreen: () -> Unit,
    onNavigateToSellerScreen: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(all = 0.dp),
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize().padding(contentPadding)
    ) {
        Text(
            text = "Welcome Back!",
            style = MaterialTheme.typography.displayMedium
        )
        Button(
            onClick = onNavigateToManagerScreen,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.5f)
                .padding(10.dp),
            shape = Shapes.medium,
            contentPadding = PaddingValues(0.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_broken_image),
                    contentDescription = "loading",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f),
                )
                Text(
                    text = stringResource(R.string.home_manager_button),
                    style = MaterialTheme.typography.titleLarge,
                )
            }
        }

        Button(
            onClick = onNavigateToSellerScreen,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.5f)
                .padding(10.dp),
            shape = Shapes.medium,
            contentPadding = PaddingValues(0.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_broken_image),
                    contentDescription = "loading",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f),
                )
                Text(
                    text = stringResource(R.string.home_seller_button),
                    style = MaterialTheme.typography.titleLarge,
                )
            }
        }
    }
}


@Preview
@Composable
private fun HomeScreenPreview(){
    HomeScreen(
        onNavigateToManagerScreen = {},
        onNavigateToSellerScreen = {},
        modifier = Modifier.fillMaxSize(),
    )
}