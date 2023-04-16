package com.learning.data.model.business

data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String?,
    val rating: ProductRating?=null
)

data class ProductRating(
    val rate: Double,
    val count: Int
)
