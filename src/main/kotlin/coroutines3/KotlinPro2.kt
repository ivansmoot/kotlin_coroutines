package coroutines3

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
    使用async,await
 */
fun main() = runBlocking {
    // 获取函数执行时间
    val elapsedTime = measureTimeMillis {
        val value1 = async { intValue1() }
        val value2 = async { intValue2() }
        val result1 = value1.await()
        val result2 = value2.await()
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