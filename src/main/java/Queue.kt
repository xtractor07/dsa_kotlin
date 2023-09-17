class Queue<T> : QueueInterface<T> {

    private val storage = arrayListOf<T>()
    override val count: Int
        get() = storage.size
    override val isEmpty: Boolean
        get() = count == 0
    override fun peek(): T? {
        return storage.getOrNull(0)
    }
    override fun dequeue(): T? {
        return if (isEmpty) null else storage.removeAt(0)
    }
    override fun enqueue(element: T): Boolean {
        return storage.add(element)
    }
}

fun main () {
    val queue = Queue<Int>()
    queue.enqueue(20)
    queue.enqueue(30)
    queue.enqueue(40)
    queue.enqueue(50)
    println("${queue.dequeue()}")
    println("${queue.dequeue()}") 
}

interface QueueInterface<T>{
    val count: Int
    val isEmpty: Boolean
    fun peek(): T?
    fun enqueue(element: T): Boolean
    fun dequeue(): T?
}
