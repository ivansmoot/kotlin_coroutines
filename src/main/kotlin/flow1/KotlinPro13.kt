package flow1

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/*
    Flow的收集动作发生在调用协程的上下文中, 上下文保留
 */

private fun log(msg: String) = println("[${Thread.currentThread().name}], $msg")

private fun myMethod(): Flow<Int> = flow {
    log("started")
    for (i in 1..3) {
        emit(i)
    }
}

fun main() = runBlocking {
    myMethod().collect {
        log("collected: $it")
    }
}