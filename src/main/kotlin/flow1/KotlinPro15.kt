package flow1

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
    Buffer
 */
private fun myMethod(): Flow<Int> = flow {
    for (i in 1..4) {
        delay(100)
        emit(i)
    }
}

fun main() = runBlocking {
    val time = measureTimeMillis {
        myMethod().buffer().collect {
            delay(200)
            println(it)
        }
    }

    println(time)
}