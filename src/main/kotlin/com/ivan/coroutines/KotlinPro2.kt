package com.ivan.coroutines

import kotlin.concurrent.thread

fun main() {

    // 使用线程
    thread {
        Thread.sleep(1000)
        println("kotlin thread")
    }

    println("first")

    Thread.sleep(2000)

    println("last")
}