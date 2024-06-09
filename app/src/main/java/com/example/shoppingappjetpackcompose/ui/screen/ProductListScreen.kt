package com.example.shoppingappjetpackcompose.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.shoppingappjetpackcompose.R
import com.example.shoppingappjetpackcompose.data.model.product.ProductsItemModel
import com.example.shoppingappjetpackcompose.ui.viewmodel.ProductViewModel


@Composable
fun ShoppingCartList(viewmodel: ProductViewModel = hiltViewModel()) {
    val products by viewmodel.products.collectAsState()
    val selectedProduct by viewmodel.selectedProduct.collectAsState()



    Column {
        MyTopAppBar()
        LazyColumn {


            items(products.size) { index ->
                products[index]?.let {
                    ProductItem(product = it) { product ->
                        viewmodel.selectProduct(product)
                    }

                }
//                selectedProduct?.let { product ->
//                    EditPriceDialog(
//                        product = product,
//                        onPriceChange = { newPrice -> viewmodel.updateProductPrice(newPrice) },
//                        onDismiss = { viewmodel.selectProduct(null) })
//
//
//                }

            }
        }
    }
}

@Composable
fun ShoppingCartList1(viewmodel: ProductViewModel = hiltViewModel()) {
    val products by viewmodel.products.collectAsState()
    val selectedProduct by viewmodel.selectedProduct.collectAsState()


    Column {

    }
}

@Composable
fun ProductItemTest(product: ProductsItemModel, onClick: (ProductsItemModel) -> Unit) {
    var price by remember { mutableStateOf(product.price) }
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

@Composable
fun ProductItem(product: ProductsItemModel, onEditClick: (ProductsItemModel) -> Unit) {
    var isEditing by remember { mutableStateOf(false) }
    var price by remember { mutableStateOf(product.price) }
    val lemonMilk = FontFamily(Font(R.font.lemon_milk_bold))

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { isEditing = !isEditing },
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = rememberImagePainter(data = product.image),
                contentDescription = product.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(250.dp)
                    .width(300.dp)
                    .padding(bottom = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )

            product.title?.let {
                Text(
                    text = it,
                    style = androidx.compose.ui.text.TextStyle(
                        fontFamily = lemonMilk,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        color = Color.Black
                    ),
                    modifier = Modifier.padding(bottom = 10.dp)
                )
            }



            product.description?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(bottom = 8.dp)

                )
            }


            if (isEditing) {
                Column {
                    OutlinedTextField(
                        value = price.toString(),
                        onValueChange = { newValue -> price = newValue.toDoubleOrNull() ?: price },
                        label = { Text("Price") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Button(
                        onClick = {
                            onEditClick(product.copy(price = price))
                            isEditing = false
                        },
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(top = 8.dp)
                    ) {
                        Text("Update")
                    }
                }
            } else {
                Row {


                    Text(
                        text = "Price: $${price}",
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                        color = Color.Black,
                        modifier = Modifier.padding()
                    )
                    Text(
                        text = "Rating: ${product.rating?.rate} (${product.rating?.count} reviews)",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Black,
                        modifier = Modifier.padding(horizontal = 30.dp)
                    )
                }
            }
        }
    }

}



