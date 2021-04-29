package coroutines1

fun main() {
    test(5) {
        println("kotlin")
    }

    test2(5,){
        println(it)
    }

    test(5, ::test3)

    test2(5, ::test4)

    test5(5, ::test6)
}

fun test(x: Int, action: () -> Unit) {
    action()
}

fun test2(x: Int, action: (Int) -> Unit) {
    action(x)
}

fun test3() {

}

fun test4(x: Int) {

}

fun test5(x: Int, action: (Int, Int) -> Unit) {
    action(1, 2)
}

fun test6(x: Int, y: Int) {
    print(x + y)
}