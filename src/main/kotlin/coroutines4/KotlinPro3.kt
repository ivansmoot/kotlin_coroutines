package coroutines4

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking


/*
    使用JVM参数 -Dkotlinx.coroutines.debug ,能把协程名也打出来
    点运行按钮左边的箭头,选Edit Configurations,在VM Options里面加这个配置
 */
private fun log(logMessage: String) = println("[${Thread.currentThread().name}] $logMessage")

fun main() = runBlocking<Unit> {
    val a = async {
        log("hello")
        10
    }

    val b = async {
        log("world")
        20
    }

    log("result is ${a.await() * b.await()}")
}
