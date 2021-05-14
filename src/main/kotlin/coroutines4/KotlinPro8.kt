package coroutines4

import kotlinx.coroutines.*

// 把default改成main, 会抛异常, 因为没有安卓相关依赖
class Activity: CoroutineScope by CoroutineScope(Dispatchers.Default) {

    fun destroy() {
        cancel()
    }

    fun doSomething() {
        repeat(8) { i ->
            launch {
                delay((i + 1) * 300L)
                println("coroutine $i is finished")
            }
        }
    }
}

fun main() = runBlocking {
    val activity = Activity()
    activity.doSomething()

    println("start coroutine")
    delay(1300L)
    println("destroy activity")
    activity.destroy()
    delay(5000L)
}