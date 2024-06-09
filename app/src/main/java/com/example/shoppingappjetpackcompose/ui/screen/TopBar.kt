package com.example.shoppingappjetpackcompose.ui.screen

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
@Composable
fun MyTopAppBar() {
    TopAppBar(
        title = { Text(text = "Store") },
        backgroundColor = MaterialTheme.colors.primaryVariant,
        contentColor = Color.White,
        elevation = 4.dp
    )
}