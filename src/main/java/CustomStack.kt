class CustomStack<T> : IStack<T> {

    private val elements: MutableList<T> = mutableListOf()
    override fun isEmpty(): Boolean {
        return elements.isEmpty()
    }
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

    fun printStack() {
        for(idx in elements.size - 1 downTo 0) {
            print("${elements[idx]} -> ")
        }
        println()
    }
}
