package dataStructures.interfaces

interface IQueue<T> {
    fun isEmpty(): Boolean
    fun enqueue(item: T)
    fun dequeue(): T?
    fun front(): T?
    fun rear(): T?
    fun size(): Int
}
