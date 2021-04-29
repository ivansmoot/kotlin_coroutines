package coroutines3

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


fun main() = runBlocking {
    val elapsedTime = measureTimeMillis {
        val value1 = async(start = CoroutineStart.LAZY) { intValue1() }
        val value2 = async(start = CoroutineStart.LAZY) { intValue2() }

        println("hello")
        Thread.sleep(6000)

        // 不start就成了串行
//        value1.start()
//        value2.start()

        val result2 = value2.await()
        val result1 = value1.await()

        println("$result1 + $result2 = ${result1 + result2}")
    }
    println("totalTime: $elapsedTime")
}

private suspend fun intValue1(): Int {
    delay(2000)
    return 15
}

private suspend fun intValue2(): Int {
    delay(3000)
    return 20
}