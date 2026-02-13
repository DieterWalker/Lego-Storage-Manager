package com.example.legostoragemanager.ui.piecesManager

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.legostoragemanager.R
import com.example.legostoragemanager.data.database.PiecesCategory
import com.example.legostoragemanager.ui.navigation.NavigationDestination

object PiecesDetailDestination: NavigationDestination {
    override val route = "pieces_detail"
    override val titleRes = R.string.piece_detail_screen
}

/**
 * Hàm định nghĩa màn hình chi tiết viên gạch
 * */
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
            onSubmit = {},
            contentPadding = innerPadding,
        )
    }
}

/**
 * Hàm định nghĩa phần TopBar của màn hình thông tin khối gạch
 * */
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

/**
 * Hàm định nghĩa phần nội dung của màn hình thông tin khối gạch
 * */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PiecesDetailBody(
    modifier: Modifier = Modifier,
    onSubmit: () -> Unit,
    contentPadding: PaddingValues = PaddingValues(0.dp),
){
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }

    val imagePickerLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
        ) { uri: Uri? ->
            // tạm thời chỉ log / giữ lại
            selectedImageUri = uri
        }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            )
            .padding(contentPadding)
    ) {
        /** Gọi hàm định nghĩa hình ảnh của khối gạch */
        PiecesDetailUploadImage(
            onClick = {  imagePickerLauncher.launch("image/*") },
            selectedImageUri = selectedImageUri
        )

        /** Gọi hàm ô nhập tên của khối gạch */
        PiecesDetailTextField(
            textFieldLabel = "Name", textFieldType = PiecesDetailTextFieldType.TEXT
        )

        /** Gọi hàm ô nhập tên của khối gạch */
        PiecesDetailTextField(
            textFieldLabel = "Quality", textFieldType = PiecesDetailTextFieldType.NUMBER
        )

        /** Gọi hàm ô nhập tên của khối gạch */
        PiecesDetailTextField(
            textFieldLabel = "Price", textFieldType = PiecesDetailTextFieldType.NUMBER
        )

        /**  */
        PiecesDetailDropDown(
        )

        PiecesDetailSubmitButton(
            onSubmit = onSubmit,
        )

    }
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
private fun PiecesDetailUploadImage(
    onClick: () -> Unit,
    selectedImageUri: Uri?,
){
    PiecesDetailImage(
        selectedImageUri = selectedImageUri
    )


    PiecesDetailUploadButton(
        onClick = onClick
    )
}

@Composable
private fun PiecesDetailUploadButton(
    onClick: () -> Unit
){
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(
            text = "Select Image"
        )
    }
}

@Composable
private fun PiecesDetailSubmitButton(
    onSubmit: () -> Unit
){
    Button(
        onClick = onSubmit,
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(
            text = "Submit"
        )
    }
}

@Composable
private fun PiecesDetailImage(
    selectedImageUri: Uri?
){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .padding(25.dp),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 8.dp,
//        color = MaterialTheme.colorScheme.surface
        ) {
        AsyncImage(
            model = selectedImageUri?: R.drawable.loading_img,
            contentDescription = "Upload Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
    }
}

@Composable
private fun PiecesDetailTextField(textFieldLabel: String, textFieldType: PiecesDetailTextFieldType){
    var textValue by remember { mutableStateOf("") }
    OutlinedTextField(
        value = textValue,
        onValueChange = { textValue = it},
        keyboardOptions = KeyboardOptions(
            keyboardType = if (textFieldType == PiecesDetailTextFieldType.NUMBER){
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