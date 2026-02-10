package com.example.legostoragemanager.ui.piecesManager

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.legostoragemanager.R
import com.example.legostoragemanager.data.database.Pieces
import com.example.legostoragemanager.data.database.PiecesCategory
import com.example.legostoragemanager.ui.home.HomeDestination
import com.example.legostoragemanager.ui.navigation.NavigationDestination
import java.util.Locale

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PiecesDetailBody(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            )
            .padding(contentPadding)
    ) {
        PiecesDetailUploadImage(
            onClick = {}
        )

        PiecesDetailTextField(
            "Name", "text"
        )
        PiecesDetailTextField(
            "Quality", "number"
        )
        PiecesDetailTextField(
            "Price", "number"
        )

        PiecesDetailDropDown(

        )

    }
}

@Composable
private fun PiecesDetailUploadImage(
    onClick: () -> Unit,
){
    PiecesDetailImage()
    PiecesDetailUploadButton(
        onClick = onClick,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PiecesDetailDropDown(

){
    val categoryList = PiecesCategory.entries.toList()
    var categoryExpanded by remember { mutableStateOf(false) }
    var selectedCategory by remember { mutableStateOf("BRICKS") }
    ExposedDropdownMenuBox(
        expanded = categoryExpanded,
        onExpandedChange = {categoryExpanded = !categoryExpanded}
    ) {
        OutlinedTextField(
            value = selectedCategory,
            onValueChange = {},
            readOnly = true,
            label = {
                Text(
                    text = "Category"
                )
            },
            trailingIcon = {
              ExposedDropdownMenuDefaults.TrailingIcon(expanded = categoryExpanded)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .menuAnchor()
        )


        ExposedDropdownMenu(
            expanded = categoryExpanded,
            onDismissRequest = { categoryExpanded = false }
        ) {
            categoryList.forEach { category ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = category.name
                        )
                    },
                    onClick = {
                        selectedCategory = category.name
                        categoryExpanded = false
                    }
                )
            }
        }
    }
}

@Composable
private fun PiecesDetailUploadButton(
    onClick: () -> Unit
){
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Upload Image"
        )
    }
}

@Composable
private fun PiecesDetailImage(){
    Image(
        painter = painterResource(R.drawable.loading_img),
        contentDescription = "Upload Image",
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
    )
}

@Composable
private fun PiecesDetailTextField(textFieldLabel: String, textFieldType: String){
    var textValue by remember { mutableStateOf("") }
    OutlinedTextField(
        value = textValue,
        onValueChange = { textValue = it},
        keyboardOptions = KeyboardOptions(
            keyboardType = if (textFieldType == "number"){
                KeyboardType.Number
            } else {
                KeyboardType.Text
            }
        ),
        label = {
            Text(
                text = textFieldLabel
            )},
        placeholder  = {
            Text(
                text = ""
            )},
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    )
}

@Preview
@Composable
fun  PiecesDetailScreenPreview() {
    PiecesDetailScreen(
        onBack = {},
        modifier = Modifier.fillMaxSize()
    )
}