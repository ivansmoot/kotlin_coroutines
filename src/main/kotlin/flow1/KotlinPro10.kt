package flow1

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking

fun myNumbers(): Flow<Int> = flow {
    emit(1)
    emit(2)
    println("hello")
    emit(3)
}

fun main() = runBlocking<Unit> {
    // 只拿两个
    myNumbers().take(2).collect { println(it) }
}