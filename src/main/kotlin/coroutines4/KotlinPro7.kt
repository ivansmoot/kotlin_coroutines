package coroutines4

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val request = launch {
        repeat(5) { i ->
            launch {
                delay(100)
                println("$i done")
            }
        }
        println("hello")
    }

    // join会等request执行结束再继续
    request.join()
    println("world")
}