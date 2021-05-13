package coroutines4

import kotlinx.coroutines.Job
import kotlinx.coroutines.isActive
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val job: Job? = coroutineContext[Job]
    println(job)

    println(coroutineContext.isActive)
    println(coroutineContext[Job]?.isActive)
}