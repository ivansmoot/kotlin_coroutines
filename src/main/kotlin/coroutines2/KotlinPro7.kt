package coroutines2

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() = runBlocking {
    val result = withTimeoutOrNull(2000) {
        repeat(1000){
            i -> println("hello, $i")
            delay(40)
        }
    }
    println("result is $result")
}