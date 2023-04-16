package com.learning

object FakeStoreApi{
    const val ALL_PRODUCT = "https://fakestoreapi.com/products"
    const val SINGLE_PRODUCT = "https://fakestoreapi.com/products/"               //https://fakestoreapi.com/products/1 [id will append at routing in runtime]
    const val GET_PRODUCT_WITH_LIMIT = "https://fakestoreapi.com/products?limit=" //e.g. https://fakestoreapi.com/products?limit=5
    const val ALL_CATEGORIES = "https://fakestoreapi.com/products/categories"
    const val ALL_PRODUCT_IN_CATEGORY = "https://fakestoreapi.com/products/category/"
}

object AppStoreApi{
    const val ALL_PRODUCT = "/products"
    const val SINGLE_PRODUCT = "/{id}"
    const val ALL_CATEGORIES = "/categories"
    const val ALL_PRODUCT_IN_CATEGORY = "$ALL_CATEGORIES/{categoryName}"
}