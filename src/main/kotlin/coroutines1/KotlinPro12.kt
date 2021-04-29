package coroutines1

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/*
    全局协程类似于守护线程
    使用GlobalScope启动的活动协程并不会保持进程的生命,进程执行完了就没了,不会等协程结束,像守护线程一样
 */

fun main() {
    GlobalScope.launch {
        repeat(100) {
            println("sleeping...$it")
            delay(500)
        }
    }

    Thread.sleep(2000)
}