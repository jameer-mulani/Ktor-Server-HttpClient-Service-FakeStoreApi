package com.learning.routes

import com.learning.AppStoreApi
import com.learning.FakeStoreApi
import com.learning.MyHttpClient
import com.learning.data.model.business.Product
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.storeRouting() {

    route(AppStoreApi.GET_ALL_PRODUCT) {

        get {
            val result = MyHttpClient.getClient()
                .get(FakeStoreApi.GET_ALL_PRODUCT)
                .body<List<Product>>()
            call.respond(result)
        }

    }

}