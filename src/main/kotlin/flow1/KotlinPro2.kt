package flow1

/*
    序列 Sequence
    获取每个元素时,都有阻塞的计算
    序列是算一个返回一个,不是算完了再返回
    序列使用主线程,所以会阻塞主线程
 */
private fun myMethod(): Sequence<Int> = sequence {
    for (i in 100..105) {
        Thread.sleep(1000)
        yield(i)
    }
}

fun main() {
    myMethod().forEach { println(it) }
}