package com.example.legostoragemanager.ui.piecesManager

import android.content.pm.ModuleInfo
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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

object PiecesManagerDestination: NavigationDestination{
    override val route = "piece_manager"
    override val titleRes = R.string.piece_manager_screen
}
@Composable
fun PiecesManagerScreen(
    onBack: () -> Unit = {},
    modifier: Modifier = Modifier
){
    Scaffold(
        topBar = {
            PiecesManagerTopBar(
                onBack = onBack,
                modifier = modifier
            )
        }
    ) { innerPadding ->

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PiecesManagerTopBar(
    onBack: () -> Unit,
    modifier: Modifier = Modifier
){
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
                    text = stringResource(PiecesManagerDestination.titleRes),
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    )
}

@Preview
@Composable
fun PiecesManagerPreview(){
    PiecesManagerScreen()
}