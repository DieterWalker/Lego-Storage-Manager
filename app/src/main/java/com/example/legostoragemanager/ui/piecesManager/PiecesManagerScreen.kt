package com.example.legostoragemanager.ui.piecesManager

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.legostoragemanager.R
import com.example.legostoragemanager.data.database.Pieces
import com.example.legostoragemanager.data.database.PiecesCategory
import com.example.legostoragemanager.ui.navigation.NavigationDestination
import kotlin.Int
import kotlin.String

object PiecesManagerDestination: NavigationDestination{
    override val route = "piece_manager"
    override val titleRes = R.string.piece_manager_screen
}
@Composable
fun PiecesManagerScreen(
    piecesList: List<Pieces>,
    modifier: Modifier = Modifier,
    onBack: () -> Unit = {},
    onNavigateToPiecesDetail: () -> Unit,
){
    Scaffold(
        topBar = {
            PiecesManagerTopBar(
                onNavigateToPiecesDetail = onNavigateToPiecesDetail,
                onBack = onBack,
                modifier = modifier
            )
        }
    ) { innerPadding ->
        PiecesManagerBody(
            piecesList = piecesList,
            contentPadding = innerPadding,
        )
    }
}

@Composable
fun PiecesManagerBody(
    piecesList: List<Pieces>,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    if (piecesList.isEmpty()){
        Text(
            text = "There is nothing here yet. Tap the '+' button to add pieces.",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        )
    } else {
        Text(
            text = "LOADING...",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        )
        PiecesList(
            piecesList = piecesList,
            contentPadding = contentPadding
        )
    }
}

@Composable
fun PiecesList (
    piecesList: List<Pieces>,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    modifier: Modifier = Modifier
){
    LazyColumn(
        modifier = Modifier,
        contentPadding = contentPadding
    ) {
        items(
            items = piecesList,
            key = {it.id}
        ){ piece ->
            PieceItem(
                piece = piece,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun PieceItem(
    piece: Pieces,
    modifier: Modifier = Modifier
){
    Row() {
        Text(
            text = piece.name
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PiecesManagerTopBar(
    onNavigateToPiecesDetail: () -> Unit,
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
                Spacer(
                    modifier = Modifier.weight(1f)
                )
                IconButton(
                    onClick = onNavigateToPiecesDetail,
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Pieces",
                    )
                }
            }
        }
    )
}

@Preview
@Composable
private fun PiecesManagerPreview(){
    PiecesManagerScreen(
        modifier = Modifier.fillMaxSize(),
        onBack = {},
        onNavigateToPiecesDetail = {},
        piecesList = listOf(
            Pieces(
                id = 0,
                name = "Brick",
                price = 0.49,
                quantity = 21,
                category = PiecesCategory.BRICKS
            ),
            Pieces(
                id = 1,
                name = "Red Brick",
                price = 1.49,
                quantity = 121,
                category = PiecesCategory.BRICKS
            ),
        )
    )
}