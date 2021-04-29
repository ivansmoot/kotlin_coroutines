package coroutines2

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

/*
    协程的超时
 */
fun main() = runBlocking {
    withTimeout(2000) {
        repeat(1000) {
            i -> println("hello, $i")
            delay(40)
        }
    }
}