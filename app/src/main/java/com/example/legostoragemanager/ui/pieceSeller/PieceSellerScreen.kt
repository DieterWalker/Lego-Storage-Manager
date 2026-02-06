package com.example.legostoragemanager.ui.pieceSeller

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.legostoragemanager.R
import com.example.legostoragemanager.ui.navigation.NavigationDestination
import com.example.legostoragemanager.ui.piecesManager.PiecesManagerDestination
import com.example.legostoragemanager.ui.piecesManager.PiecesManagerTopBar

object PiecesSellerDestination: NavigationDestination{
    override val route = "pieces_seller"
    override val titleRes = R.string.piece_seller_screen
}

@Composable
fun PiecesSellerScreen(
    modifier: Modifier = Modifier,
    onBack: () -> Unit = {},

    ){
    Scaffold(
        topBar = {
            PiecesSellerTopBar(
                onBack = onBack,
                modifier = modifier
            )
        }
    ) { innerPadding ->
        Text(
            text = "This feature is under development",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.fillMaxSize().padding(innerPadding)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PiecesSellerTopBar(
    onBack: () -> Unit,
    modifier: Modifier
) {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = onBack,
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Go Back"
                    )
                }
                Text(
                    text = stringResource(PiecesSellerDestination.titleRes),
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    )
}

@Preview
@Composable
private fun PieceSellerPreview(){
    PiecesSellerScreen()
}

