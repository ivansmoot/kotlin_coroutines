package coroutines

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    使用finally来关闭资源
    join和cancelAndJoin会等待所有清理动作执行完成才会继续往下执行
 */

fun main() = runBlocking {
    val myJob = launch {
        try {
            repeat(100) {
                println("job: I am sleep $it")
                delay(500)
            }
        } finally {
            println("finally")
        }
    }

    delay(1300)
    println("hello")

    myJob.cancelAndJoin()
    println("welcome")
}