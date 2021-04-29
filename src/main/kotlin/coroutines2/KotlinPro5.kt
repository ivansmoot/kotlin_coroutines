package coroutines2

import kotlinx.coroutines.*

/*
    在finally中调用挂起函数,会出现CancellationException异常.
    因为协程已经被取消了,不能使用挂起函数
 */
fun main() = runBlocking {
    val myJob = launch {
        try {
        } finally {
            println("1")
//            delay(1000)  // delay的话,后面的就打不出来了
            // 你如果非要用挂起函数,就这样用
            withContext(NonCancellable) {
                println("2")
                delay(1000)
                println("4")
            }
            println("5")
        }
    }
    delay(1000)
    println("3")
    myJob.cancelAndJoin()
}