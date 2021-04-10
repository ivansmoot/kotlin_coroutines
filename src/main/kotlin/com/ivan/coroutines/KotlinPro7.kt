package com.ivan.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    按理说coroutineScope不会阻塞当前线程的执行,为什么fifth不是接在first后面打印出来的?
    1.runBlocking并非挂起函数,调用它的线程会一直位于该函数之中,直到协程执行完毕为止
    2.coroutineScope是挂起函数,如果其中的协程挂起,那么coroutineScope函数也会挂起,这样,创建coroutineScope的外层函数就可以继续在同一个线程中执行,
      该线程会逃离coroutineScope之外.并且可以做一些其他事情
    coroutineScope不阻塞当前线程是指,third能被打印出来,如果线程被coroutineScope阻塞,则third是打印不出来的,fifth没有立即被打印是因为要等
    coroutineScope执行完,但这不意味着coroutineScope会阻塞线程
 */

fun main() = runBlocking {

    launch {
        delay(1000)
        println("third")
    }

    println("first")

    // coroutineScope和delay一样会阻塞线程流继续
    coroutineScope {
        launch {
            delay(3000)
            println("forth")
        }

        delay(500)
        println("second")
    }

    println("fifth")

}