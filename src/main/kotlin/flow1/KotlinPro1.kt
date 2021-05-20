package flow1

/*
    方法本身是阻塞的,主线程先进来,再执行到方法结束为止
    数据一次性返回全部
 */
private fun myMethod(): List<String> = listOf("hello", "world")

fun main() {
    myMethod().forEach { println(it) }
}