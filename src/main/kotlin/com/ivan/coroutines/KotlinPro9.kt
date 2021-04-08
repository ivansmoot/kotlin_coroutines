package com.ivan.coroutines

import kotlin.concurrent.thread

fun main() {
    repeat(10000) {
        thread {
            Thread.sleep(1000)
            println("kkk")
        }
    }

    println("ttt")
}