package coroutines4

import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

private fun log(logMessage: String) = println("[${Thread.currentThread().name}] $logMessage")

@ObsoleteCoroutinesApi
fun main() {
    newSingleThreadContext("Context1").use { ctx1 ->
        newSingleThreadContext("Context2").use { ctx2 ->
            runBlocking(ctx1) {
                log("start in context1")
                withContext(ctx2) {
                    log("working with context2")
                }
                log("back to context1")
            }
        }
    }
}