package flow1

import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
    Flatten Flow
    Flow<Flow<Int>> -> Flow<Int>
 */

private fun myMethod(i: Int): Flow<String> = flow {
    emit("$i: First")
    delay(500)
    emit("$i: second")
}

@FlowPreview
fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    (1..3).asFlow().onEach {
        delay(100)
    }.flatMapConcat {
        myMethod(it)
    }.collect {
        println("$it at ${System.currentTimeMillis() - startTime} ms")
    }
}