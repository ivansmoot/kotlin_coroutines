package com.ivan.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    被suspend修饰的函数被称为挂起函数
    挂起函数可以像普通函数一样用在协程中
    挂起函数只能用在协程或其他挂起函数中
 */

fun main() = runBlocking {
    launch {
        world()
    }
    println("kotlin")
}

suspend fun hello() {
    delay(4000)
    println("hello")
}

suspend fun world() {
    hello()
}