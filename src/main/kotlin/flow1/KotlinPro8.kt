package flow1

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

/*
    Flow的中间运算符
 */

private suspend fun myMethod(input: Int): String {
    delay(1000)
    return "output: $input"
}

fun main() = runBlocking<Unit> {
    (1..10).asFlow()
        .filter { it % 2 == 0 }
        .map{ input -> myMethod(input) }
        .collect { println(it) }
}