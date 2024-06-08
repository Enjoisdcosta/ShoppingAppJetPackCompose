package com.example.shoppingappjetpackcompose.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppingappjetpackcompose.data.model.product.ProductsItemModel
import com.example.shoppingappjetpackcompose.data.repository.ShoppingProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(private val repository: ShoppingProductRepository) : ViewModel() {

    private val _products = MutableLiveData<List<ProductsItemModel>>()
    val products: LiveData<List<ProductsItemModel>> = _products

    private val _selectedProduct = MutableLiveData<ProductsItemModel?>()
    val selectedProduct: LiveData<ProductsItemModel?> = _selectedProduct

    init {
        fetchProducts()
    }

    fun fetchProducts() {
        viewModelScope.launch {
            try {
                val productsList = repository.getProducts()
                _products.value = productsList
            } catch (e: Exception) {
                // Handle the error
            }
        }
    }}
