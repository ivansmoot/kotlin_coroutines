package flow1

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/*
    Flow Exception
 */
private fun myMethod(): Flow<Int> = flow {
    for (i in 1..3){
        println("emitting $i")
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    try {
        myMethod().collect {
            println(it)
            check(it <= 1) {
                "Collected $it"
            }
        }
    } catch (e: Throwable) {
        println("caught: $e")
    }
}
