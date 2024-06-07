package com.example.shoppingappjetpackcompose.data.api


import com.example.shoppingappjetpackcompose.data.model.product.ProductsItemModel
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET


interface APIEndpoints {

    @GET(APIDetails.PRODUCTS_ENDPOING)
    suspend fun getProducts(): Flow<List<ProductsItemModel?>?>


}