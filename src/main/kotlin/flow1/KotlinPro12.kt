package flow1

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

/*
    Flow运行在调用终止操作（如collect）的那个协程上，默认不启用新的协程
    一个元素处理完了, 才会处理下一个元素
 */

fun main() = runBlocking<Unit> {
    (1..10).asFlow().filter {
        println("filter: $it")
        it % 2 == 0
    }.map {
        println("map: $it")
        "hello: $it"
    }.collect {
        println("collect: $it")
    }
}