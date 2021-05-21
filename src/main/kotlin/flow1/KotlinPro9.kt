package flow1

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking

/*
    transform
 */

private suspend fun myMethod(input: Int): String {
    delay(1000)
    return "output: $input"
}

fun main() = runBlocking<Unit> {
    (1..10).asFlow().transform { input ->
        emit("input: $input")
        emit(myMethod(input))
    }.collect { println(it) }
}