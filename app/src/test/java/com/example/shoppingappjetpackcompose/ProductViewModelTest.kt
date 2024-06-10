package com.example.shoppingappjetpackcompose

import com.example.shoppingappjetpackcompose.data.model.product.ProductsItemModel
import com.example.shoppingappjetpackcompose.data.repository.ShoppingProductRepositoryImpl
import com.example.shoppingappjetpackcompose.ui.viewmodel.ProductViewModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

@ExperimentalCoroutinesApi
class ProductViewModelTest {

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    private lateinit var repository: ShoppingProductRepositoryImpl
    private lateinit var viewModel: ProductViewModel

    @Before
    fun setUp() {
        repository = mockk()
        viewModel = ProductViewModel(repository)
    }

    @Test
    fun `test selectProduct updates selectedProduct`() = runBlockingTest {
        // Arrange
        val product = ProductsItemModel(id = 1, price = 10.0)

        // Act
        viewModel.selectProduct(product)

        // Assert
        assertEquals(product, viewModel.selectedProduct.value)

        // Act with null
        viewModel.selectProduct(null)

        // Assert
        assertNull(viewModel.selectedProduct.value)
    }

    @Test
    fun `test updateProductPrice updates price and calls repository`() = runBlockingTest {
        // Arrange
        val product = ProductsItemModel(id = 1, price = 10.0)
        coEvery { repository.updateProduct(product) } returns product

        // Act
        viewModel.selectProduct(product)
        viewModel.updateProductPrice(20.0)

        // Assert
        assertEquals(20.0, viewModel.selectedProduct.value?.price)
        coVerify { repository.updateProduct(product) }
    }
}
