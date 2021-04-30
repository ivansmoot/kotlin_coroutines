package coroutines3

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


// 不建议用这种方式使用异步
fun main() {
    val elapsedTime = measureTimeMillis {
        val value1 = intValue1Async()
        val value2 = intValue2Async()

        runBlocking {
            value1.start()
            value2.start()
            println(value1.await())
            println(value2.await())
        }
    }
    println(elapsedTime)
}

private suspend fun intValue1(): Int {
    delay(2000)
    return 15
}

private suspend fun intValue2(): Int {
    delay(3000)
    return 20
}

fun intValue1Async() = GlobalScope.async(start = CoroutineStart.LAZY) {
    intValue1()
}

fun intValue2Async() = GlobalScope.async(start = CoroutineStart.LAZY) {
    intValue2()
}