package com.learning.routes

import com.learning.AppStoreApi
import com.learning.FakeStoreApi
import com.learning.MyHttpClient
import com.learning.data.model.business.Product
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.storeRouting() {

    route(AppStoreApi.ALL_PRODUCT) {

        get {
            val result = MyHttpClient.getClient()
                .get(FakeStoreApi.ALL_PRODUCT)
                .body<List<Product>>()
            call.respond(result)
        }

        get(AppStoreApi.SINGLE_PRODUCT) {
            val id = call.parameters["id"]
            val url = FakeStoreApi.SINGLE_PRODUCT + "$id"
            val result = MyHttpClient.getClient()
                .get(url)
                .body<Product>()
            call.respond(result)
        }

        param(name = "limit") {
            get {
                val value = call.request.queryParameters["limit"]
                val url = FakeStoreApi.GET_PRODUCT_WITH_LIMIT + value
                val result = MyHttpClient.getClient()
                    .get(url)
                    .body<List<Product>>()
                call.respond(result)
            }
        }

        get(AppStoreApi.ALL_CATEGORIES) {
            val result = MyHttpClient.getClient().get(FakeStoreApi.ALL_CATEGORIES).body<Array<String>>()
            call.respond(result)
        }

        get(AppStoreApi.ALL_PRODUCT_IN_CATEGORY) {
            val categoryName = call.parameters["categoryName"]
            val url = FakeStoreApi.ALL_PRODUCT_IN_CATEGORY + categoryName
            val result = MyHttpClient.getClient()
                .get(url)
                .body<List<Product>>()
            call.respond(result)
        }

        post {
            val product = call.receive<Product>()
            val result = MyHttpClient.getClient().post(FakeStoreApi.ALL_PRODUCT){
//                url {
//                    header("Content-Type", "application/json")
//                }

                //we can write above commented content type like this
                contentType(ContentType.Application.Json)
                setBody(product)
            }.body<Product>()
            call.respond(result)
        }

        put(AppStoreApi.SINGLE_PRODUCT) {
            val id = call.parameters["id"]
            val requestBody = call.receive<Product>()
            val url = FakeStoreApi.SINGLE_PRODUCT + id
            val result = MyHttpClient.getClient().put(url){
                contentType(ContentType.Application.Json)
                setBody(requestBody)
            }.body<Product>()
            call.respond(result)
        }

        delete(AppStoreApi.SINGLE_PRODUCT) {
            val id = call.parameters["id"]
            val url = FakeStoreApi.SINGLE_PRODUCT + id
            val result = MyHttpClient.getClient().get(url).body<Product>()
            call.respond(result)
        }

    }

}