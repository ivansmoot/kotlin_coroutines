package flow1

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.runBlocking

/*
    onCompletion只看到上游的异常,但看不到下游的异常
 */
private fun myMethod(): Flow<Int> = (1..10).asFlow()

fun main() = runBlocking<Unit> {
    myMethod().onCompletion {
        println("onCompletion with error $it")
    }.collect {
        check(it <= 1) { "Collected $it" }
        println(it)
    }
}