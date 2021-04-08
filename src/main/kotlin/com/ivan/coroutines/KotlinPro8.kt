package com.ivan.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    repeat(10000) {
        launch {
            delay(1000)
            println("kkk")
        }
    }
    println("ttt")
}