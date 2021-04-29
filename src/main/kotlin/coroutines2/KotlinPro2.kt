package coroutines2

import kotlinx.coroutines.*

/*
    kotlinx.coroutines包下的所有挂起函数都是可取消的
    取消时抛出CancellationException异常
    如果某个协程处于某个计算过程中,并且没有检查取消状态,则无法被取消
 */

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (i < 20) {
            if(System.currentTimeMillis() >= nextPrintTime) {
                println("Job: I am sleeping ${i++}")
                nextPrintTime += 500L
            }
        }
    }

    delay(1300)
    println("hello world")

    job.cancelAndJoin()  // 压根没用,取消不了协程,也没有delay
    println("welcome")
}