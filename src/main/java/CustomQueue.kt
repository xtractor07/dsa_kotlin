class CustomQueue<T>: IQueue<T> {
    private val storage = arrayListOf<T>()
    override fun isEmpty(): Boolean {
        return storage.isNullOrEmpty()
    }

    override fun dequeue(): T? {
        return if (isEmpty()) null else storage.removeAt(0)
    }

    override fun front(): T? {
        return if (isEmpty()) null else storage.elementAt(0)
    }

    override fun rear(): T? {
        return if (isEmpty()) null else storage.elementAt(storage.size - 1)
    }

    override fun size(): Int {
        return storage.size
    }

    override fun enqueue(item: T) {
        storage.add(item)
    }

    fun printQueue() {
        for (i in storage) {
            print("| $i | -> ")
        }
        println()
    }
}
