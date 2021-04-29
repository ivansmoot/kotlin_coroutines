package coroutines1

import kotlin.concurrent.thread

fun main() {
    repeat(10000) {
        thread {
            Thread.sleep(1000)
            println("kkk")
        }
    }

    println("ttt")
}