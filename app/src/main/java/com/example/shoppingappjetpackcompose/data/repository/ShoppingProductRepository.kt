package com.example.shoppingappjetpackcompose.data.repository

import com.example.shoppingappjetpackcompose.data.model.product.ProductsItemModel
import kotlinx.coroutines.flow.Flow

interface ShoppingProductRepository {



    fun getProducts(): Flow<List<ProductsItemModel?>?>

}