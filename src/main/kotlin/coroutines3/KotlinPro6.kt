package coroutines3

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/*
    父子协程的异常与取消
 */

fun main() = runBlocking<Unit> {
    try {
        failureComputation()
    } finally {
        println("computation failed")
    }
}

private suspend fun failureComputation(): Int = coroutineScope {
    val value1 = async {
        try {
            delay(1000000)
            50
        } finally {
            println("value1 was cancelled")
        }
    }

    val value2 = async<Int> {
        Thread.sleep(2000)
        println("value2 throw exception")

        throw Exception()
    }

    value1.await() + value2.await()
}