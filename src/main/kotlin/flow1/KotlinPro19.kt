package flow1

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

/*
    Exception
 */
private fun myMethod(): Flow<String> =
    flow {
        for (i in 1..3) {
            println("emitting $i")
            emit(i)
        }
    }.map {
        check(it <= 1) { "crash on $it" }
        "string $it"
    }

fun main() = runBlocking<Unit> {
    try {
        myMethod().collect { println(it) }
    } catch (e: Throwable) {
        println("caught $e")
    }
}