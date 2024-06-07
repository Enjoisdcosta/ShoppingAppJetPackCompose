package com.example.shoppingappjetpackcompose.data.repository

import com.example.shoppingappjetpackcompose.data.model.product.ProductsItemModel
import kotlinx.coroutines.flow.Flow

interface ShoppingProductRepository {

    suspend fun getProducts(): Flow<List<ProductsItemModel?>?>

}