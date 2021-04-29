package coroutines2

import kotlinx.coroutines.*

/*
    如何让协程的计算代码变为可取消的?
    1.周期性地调用一个挂起函数,该挂起函数会检查取消状态
      eg:使用yield函数
    2.显式地检查取消状态

    下面是第二种
 */

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        // 用isActive判断
        while (isActive) {
            if(System.currentTimeMillis() >= nextPrintTime) {
                println("Job: I am sleeping ${i++}")
                nextPrintTime += 500L
            }
        }
    }

    delay(1300)
    println("hello world")

    job.cancelAndJoin()  // 压根没用,取消不了协程
    println("welcome")
}