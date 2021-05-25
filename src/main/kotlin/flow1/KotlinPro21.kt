package flow1

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.runBlocking

// 声明式
private fun myMethod(): Flow<Int> = (1..10).asFlow()

fun main() = runBlocking<Unit> {
    // onCompletion是在collect之后进行的
    myMethod().onCompletion { println("onCompletion") }
        .collect { println(it) }
}
