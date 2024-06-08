package com.example.shoppingappjetpackcompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppingappjetpackcompose.data.model.product.ProductsItemModel
import com.example.shoppingappjetpackcompose.data.repository.ShoppingProductRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository: ShoppingProductRepositoryImpl
) : ViewModel() {
    private val _products = MutableStateFlow<List<ProductsItemModel?>>(emptyList())
    val products: StateFlow<List<ProductsItemModel?>> = _products

    private val _selectedProduct = MutableStateFlow<ProductsItemModel?>(null)
    val selectedProduct: StateFlow<ProductsItemModel?> = _selectedProduct

    init {
        viewModelScope.launch {
            _products.value = repository.getProducts()
        }
    }

    fun selectProduct(product: ProductsItemModel?) {
        _selectedProduct.value = product
    }

    fun updateProductPrice(newPrice: Double) {
        _selectedProduct.value?.let {
            it.price = newPrice
            viewModelScope.launch {
                repository.updateProduct(it)
                // Refresh the product list
            //   _products.value = repository.getProducts()

            }
        }
    }
}