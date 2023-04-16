package com.learning

object FakeStoreApi{
    const val GET_ALL_PRODUCT = "https://fakestoreapi.com/products"
    const val GET_SINGLE_PRODUCT = "https://fakestoreapi.com/products/"
}

object AppStoreApi{
    const val GET_ALL_PRODUCT = "/products"
    const val GET_SINGLE_PRODUCT = "$GET_ALL_PRODUCT/{id}"
}