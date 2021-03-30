package com.ivan.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


fun main() {
    GlobalScope.launch {
        delay(1000)
        println("kotlin coroutines")
    }

    println("first")

    Thread.sleep(2000)

    println("last")
}
