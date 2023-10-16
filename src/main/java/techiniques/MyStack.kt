package techiniques

class MyStack<T> {

    private val storage = mutableListOf<T>()

    private fun isEmpty()= storage.isEmpty()
    fun push(data: T) {
        storage.add(data)
    }
    fun pop(): T?{
       return if (!isEmpty()) storage.removeLast() else null
    }
    fun peek(): T? {
        return if (!isEmpty()) storage.lastOrNull() else null
    }
    fun printStack() {
        println(storage.joinToString(" -> "))
    }
}

fun main() {
    val myStack = MyStack<Int>().apply {
        push(1)
        push(2)
        push(3)
        push(4)
        printStack()
    }
}
