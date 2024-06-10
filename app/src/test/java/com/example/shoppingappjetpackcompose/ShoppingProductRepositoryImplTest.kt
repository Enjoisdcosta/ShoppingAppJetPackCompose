package com.example.shoppingappjetpackcompose

import com.example.shoppingappjetpackcompose.data.api.APIEndpoints
import com.example.shoppingappjetpackcompose.data.model.product.ProductsItemModel
import com.example.shoppingappjetpackcompose.data.repository.ShoppingProductRepository
import com.example.shoppingappjetpackcompose.data.repository.ShoppingProductRepositoryImpl
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ShoppingProductRepositoryImplTest {

    @Mock
    private lateinit var apiDetail: APIEndpoints

    private lateinit var repository: ShoppingProductRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repository = ShoppingProductRepositoryImpl(apiDetail)
    }

    @Test
    fun `test getProducts returns product list`() = runBlockingTest {
        // Arrange
        val expectedProducts = listOf(ProductsItemModel(id = 1), ProductsItemModel(id = 2))
        `when`(apiDetail.getProducts()).thenReturn(expectedProducts)

        // Act
        val products = repository.getProducts()

        // Assert
        assertEquals(expectedProducts, products)
        verify(apiDetail).getProducts()
    }

    @Test
    fun `test updateProduct updates and returns product`() = runBlockingTest {
        // Arrange
        val product = ProductsItemModel(id = 1)
        `when`(apiDetail.updateProduct(product.id, product)).thenReturn(product)

        // Act
        val updatedProduct = repository.updateProduct(product)

        // Assert
        assertEquals(product, updatedProduct)
        verify(apiDetail).updateProduct(product.id, product)
    }
}
