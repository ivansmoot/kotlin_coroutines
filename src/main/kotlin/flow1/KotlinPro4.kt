package flow1

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    不阻塞
    算出来一个,返回一个
 */

// 不用suspend
private fun myMethod(): Flow<Int> = flow {
    for (i in 1..4) {
        delay(1000)
        // 值通过emit发射
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    launch {
        for (i in 1..4) {
            println("hello $i")
            delay(500)
        }
    }

    // 通过collect接收值
    myMethod().collect { println(it) }
}