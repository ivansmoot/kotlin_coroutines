package com.ivan.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    launch {
        delay(1000)
        print("kotlin coroutines")
    }

    // 直接使用launch而不是GlobalScope.launch，这里当first输出后，并没有直接关闭JVM，而是等待协程的执行完毕
    println("first")

}