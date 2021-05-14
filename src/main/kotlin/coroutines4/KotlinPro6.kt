package coroutines4

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val request = launch {
        GlobalScope.launch {
            println("j1:h")
            delay(1000)
            println("j1:w")
        }

        launch {
            delay(100)
            println("j2:h")
            delay(1000)
            println("j2:W")
        }
    }
    delay(500)
    // 父协程取消了,所有子协程都会取消(GlobalScope没有父协程)
    request.cancel()

    delay(1000)
    println("w")
}