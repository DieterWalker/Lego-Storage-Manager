package com.example.legostoragemanager.ui.piecesManager

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
import androidx.compose.ui.unit.dp
import com.example.legostoragemanager.R
import com.example.legostoragemanager.ui.home.HomeDestination
import com.example.legostoragemanager.ui.navigation.NavigationDestination

object PiecesDetailDestination: NavigationDestination {
    override val route = "pieces_detail"
    override val titleRes = R.string.piece_detail_screen
}
@Composable
fun PiecesDetailScreen(
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            PiecesDetailTopBar(
                onBack = onBack,
                modifier = modifier
            )
        }
    ) { innerPadding ->
        PiecesDetailBody(
            modifier = modifier,
            contentPadding = innerPadding
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PiecesDetailTopBar(
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
                    text = stringResource(PiecesDetailDestination.titleRes),
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    )
}

@Composable
private fun PiecesDetailBody(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
){

}

@Preview
@Composable
fun  PiecesDetailScreenPreview() {
    PiecesDetailScreen(
        onBack = {},
        modifier = Modifier.fillMaxSize()
    )
}