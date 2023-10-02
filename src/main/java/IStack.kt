interface IStack<T> {
    fun isEmpty(): Boolean
    fun push(item: T)
    fun pop(): T?
    fun peek(): T?
    fun size(): Int
}
