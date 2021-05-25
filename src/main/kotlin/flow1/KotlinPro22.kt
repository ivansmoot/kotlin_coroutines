package flow1

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.lang.RuntimeException

/*
    onCompletion有一个可空的Throwable参数, 可确定Flow的收集操作是正常完成(为空)的还是异常完成的(非空)
 */
private fun myMethod(): Flow<Int> = flow {
    emit(1)
    throw RuntimeException()
}

fun main() = runBlocking<Unit> {
    myMethod().onCompletion { cause ->
        if (cause != null)
            println("runtime error")
    }.catch {
        println("catch error")
    }.collect {
        println(it)
    }
}