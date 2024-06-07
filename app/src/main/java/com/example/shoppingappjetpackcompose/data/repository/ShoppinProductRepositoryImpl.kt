package com.example.shoppingappjetpackcompose.data.repository


import com.example.shoppingappjetpackcompose.data.api.APIEndpoints
import com.example.shoppingappjetpackcompose.data.model.product.ProductsItemModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ShoppinProductRepositoryImpl@Inject constructor(
    private val apiDetail: APIEndpoints
) :ShoppingProductRepository{
    override suspend fun getProducts(): Flow<List<ProductsItemModel?>?> {
        return apiDetail.getProducts()
    }


}