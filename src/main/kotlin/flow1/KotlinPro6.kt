package flow1

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

// 这个flow是个常见的流构建器
private fun myMethod(): Flow<Int> = flow {
    for (i in 1..10) {
        delay(100)
        println("emit: $i")
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    withTimeoutOrNull(280) {
        myMethod().collect { println(it) }
    }
    println("finished")
}