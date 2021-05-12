package coroutines4

import kotlinx.coroutines.*
import java.util.concurrent.Executors

fun main() = runBlocking<Unit> {
    launch {
        //不指定协程分发器,就继承启动它的那个coroutineScope的上下文
        println("thread1: ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Unconfined) {
        //不delay,就是在主线程执行,把delay放在print后面,也是在主线程执行
        delay(100)
        println("thread2: ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Default) {
        //后台共享线程池,等价于GlobalScope.launch{}
        println("thread3: ${Thread.currentThread().name}")
    }
    GlobalScope.launch {
        println("thread3.5: ${Thread.currentThread().name}")
    }

    //这个会让主线程一直无法退出,必须要close掉
    val thread = Executors.newSingleThreadExecutor().asCoroutineDispatcher()
    launch(thread) {
        println("thread4: ${Thread.currentThread().name}")
        thread.close()
    }
}