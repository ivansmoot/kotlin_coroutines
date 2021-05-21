package flow1

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

/*
    流构建器
    flow
    flowOf: 发射固定数量值
    用asFlow()扩展方法转为Flow
 */

fun main() = runBlocking<Unit> {
    (1..10).asFlow().collect { println(it) }

    println("------------")

    flowOf(1, 2, 3, 4).collect { println(it) }
}