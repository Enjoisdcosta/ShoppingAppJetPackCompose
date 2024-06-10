package com.example.shoppingappjetpackcompose.ui.screen

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.shoppingappjetpackcompose.data.model.product.ProductsItemModel
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class ProductListScreenKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun testShoppingCartListDisplaysProducts() {
        val products = listOf(
            ProductsItemModel(
                id = 1,
                title = "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
                price = 109.95
            ),
            ProductsItemModel(
                id = 2,
                title = "Mens Casual Premium Slim Fit T-Shirts ",
                price = 22.3
            ),
            ProductsItemModel(
                id = 4,
                title = "Mens Cotton JacketMens Cotton Jacket",
                price = 55.99
            ),
            ProductsItemModel(id = 4, title = "Mens Casual Slim Fit", price = 15.99),
            ProductsItemModel(
                id = 5,
                title = "John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet",
                price = 695.0
            ),
            ProductsItemModel(id = 6, title = "Solid Gold Petite Micropave ", price = 168.0),
            ProductsItemModel(id = 7, title = "White Gold Plated Princess", price = 9.99))


            composeTestRule.onNodeWithText("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops").assertExists()
            composeTestRule.onNodeWithText("Mens Casual Premium Slim Fit T-Shirts ").assertExists()
    }

    @org.junit.jupiter.api.Test
    fun productItem() {
    }
}