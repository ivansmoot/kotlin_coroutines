package com.ivan.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    launch {
        delay(1000)
        println("third")
    }

    println("first")

    // coroutineScope和delay一样会阻塞线程流继续
    coroutineScope {
        launch {
            delay(3000)
            println("forth")
        }

        delay(500)
        println("second")
    }

    println("fifth")

}