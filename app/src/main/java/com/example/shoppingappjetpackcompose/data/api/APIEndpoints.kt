package com.example.shoppingappjetpackcompose.data.api


import com.example.shoppingappjetpackcompose.data.model.product.ProductsItemModel
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.PUT
import retrofit2.http.Path


interface APIEndpoints {

    @GET(APIDetails.PRODUCTS_ENDPOINT)
    suspend fun getProducts(): List<ProductsItemModel?>

    @PUT(APIDetails.PRODUCTS_ID_ENDPOINT)
    suspend fun updateProduct(
        @Path("id") id: Int?,
        @Body product: ProductsItemModel
    ): ProductsItemModel


}