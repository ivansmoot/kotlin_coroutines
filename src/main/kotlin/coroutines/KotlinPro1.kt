package coroutines

import kotlinx.coroutines.*

/*
    协程的取消与超时
 */

fun main() = runBlocking {
    val myJob = launch {
        repeat(200) {
            println("hello $it")
            delay(500)  // 因为有delay,不是isActive,能正常取消协程
        }
    }

    delay(1100)
    println("hello world")

//    myJob.cancel()
//    myJob.join()

    myJob.cancelAndJoin()

    println("welcome")
}