class ArrayStack<T>: Stack<T> {
    private val elements = mutableListOf<T>()
    override fun isEmpty(): Boolean = elements.isEmpty()

    override fun push(item: T) {
        elements.add(item)
    }

    override fun pop(): T? {
        return if (isEmpty()) null else elements.removeAt(elements.size - 1)
    }

    override fun peek(): T? {
        return elements.lastOrNull()
    }

    override fun size(): Int {
        return elements.size
    }
}

interface Stack<T> {
    fun isEmpty(): Boolean
    fun push(item: T)
    fun pop(): T?
    fun peek(): T?
    fun size(): Int
}

fun main() {
    var stack: Stack<Int> = ArrayStack()

    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(4)

    println("${stack.peek()}")
}
