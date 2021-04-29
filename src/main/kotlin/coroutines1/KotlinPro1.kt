package coroutines1

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


fun main() {

    // 使用协程
    GlobalScope.launch {
        delay(1000)
        println("kotlin coroutines")
    }

    println("first")

    Thread.sleep(2000)

    println("last")
}
