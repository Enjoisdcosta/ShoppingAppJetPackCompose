package com.example.shoppingappjetpackcompose.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shoppingappjetpackcompose.data.model.product.ProductsItemModel
import com.example.shoppingappjetpackcompose.ui.viewmodel.ProductViewModel


@Composable
fun ShoppingCartList(viewmodel: ProductViewModel = hiltViewModel()) {
    val products by viewmodel.products.collectAsState()
    val selectedProduct by viewmodel.selectedProduct.collectAsState()



    Column {
        LazyColumn {
            items(products.size) { index ->
                products[index]?.let {
                    ProductItem(product = it) { product ->
                        viewmodel.selectProduct(product)
                    }
                }
                selectedProduct?.let { product ->
                    EditPriceDialog(
                        product = product,
                        onPriceChange = { newPrice -> viewmodel.updateProductPrice(newPrice) },
                        onDismiss = { viewmodel.selectProduct(null) })


                }

            }
        }
    }
}


@Composable
fun ProductItem(product: ProductsItemModel, onClick: (ProductsItemModel) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(product) }
            .padding(16.dp)
    ) {
        product.title?.let { Text(text = it, modifier = Modifier.weight(1f)) }
        Text(text = "$${product.price}")
    }
}

@Composable
fun EditPriceDialog(
    product: ProductsItemModel,
    onPriceChange: (Double) -> Unit,
    onDismiss: () -> Unit
) {
    var newPrice by remember { mutableStateOf(product.price.toString()) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Edit Price") },
        text = {
            Column {
                TextField(
                    value = newPrice,
                    onValueChange = { newPrice = it },
                    label = { Text("Price") }
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    onPriceChange(newPrice.toDouble())
                    onDismiss()
                }
            ) {
                Text("Update")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}

