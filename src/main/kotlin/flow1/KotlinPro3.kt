package flow1

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/*
    coroutine
    不阻塞主线程
    一次性返回
 */
private suspend fun myMethod(): List<String> {
    delay(1000)

    return listOf("hello", "world")
}

fun main() = runBlocking {
    myMethod().forEach { println(it) }
}