package flow1

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

private fun myMethod(): Flow<Int> = flow{
    println("myMethod executed")

    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    println("hello")
    // 光发射不接收,等于没执行
    val flow = myMethod()
    println("world")
}