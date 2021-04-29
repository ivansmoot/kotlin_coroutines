package coroutines1

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val myJob = GlobalScope.launch {
        delay(1000)
        println("kotlin coroutines")
    }

    println("first")

    // 等myJob这个协程执行完毕
    myJob.join()

    println("last")

}