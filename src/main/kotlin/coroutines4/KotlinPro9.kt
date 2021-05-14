package coroutines4

import kotlinx.coroutines.*

/*
    ThreadLocal
 */

val threadLocal = ThreadLocal<String>()

fun main() = runBlocking<Unit> {
    threadLocal.set("hello")
    println("current thread: ${Thread.currentThread()}, thread local value: ${threadLocal.get()}")

    val job = launch(Dispatchers.Default + threadLocal.asContextElement("world")) {
        println("current thread: ${Thread.currentThread()}, thread local value: ${threadLocal.get()}")
        yield()
        println("current thread: ${Thread.currentThread()}, thread local value: ${threadLocal.get()}")
    }

    job.join()
    println("current thread: ${Thread.currentThread()}, thread local value: ${threadLocal.get()}")
}