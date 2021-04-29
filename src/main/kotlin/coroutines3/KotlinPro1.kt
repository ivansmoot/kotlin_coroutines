package coroutines3

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
    挂起函数的组合
    这样慢,相当于串行的
 */
fun main() = runBlocking {
    // 获取函数执行时间
    val elapsedTime = measureTimeMillis {
        val value1 = intValue1()
        val value2 = initValue2()
        println("$value1 + $value2 = ${value1 + value2}")
    }
    println("totalTime: $elapsedTime")
}

private suspend fun intValue1(): Int {
    delay(2000)
    return 15
}

private suspend fun initValue2(): Int {
    delay(3000)
    return 20
}