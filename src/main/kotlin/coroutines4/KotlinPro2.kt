package coroutines4

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    /*
        Unconfined在调用者线程中启动协程,但仅仅会持续到第一个挂起点
        挂起后协程的线程是挂起函数决定的
        使用情况: 不消耗CPU时间,不更新共享数据
     */
    launch(Dispatchers.Unconfined) {
        println("thread1: ${Thread.currentThread().name}")
        delay(300)
        println("thread2: ${Thread.currentThread().name}")
    }
}