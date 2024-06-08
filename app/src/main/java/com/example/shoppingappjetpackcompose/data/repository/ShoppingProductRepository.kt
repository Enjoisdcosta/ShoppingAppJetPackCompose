package com.example.shoppingappjetpackcompose.data.repository

import com.example.shoppingappjetpackcompose.data.model.product.ProductsItemModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit

interface ShoppingProductRepository {


    suspend fun getProducts(): List<ProductsItemModel?>
    suspend fun updateProduct(product: ProductsItemModel): ProductsItemModel?


}