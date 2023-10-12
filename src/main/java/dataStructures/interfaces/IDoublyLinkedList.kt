package dataStructures.interfaces

interface IDoublyLinkedList<T> {
    fun insertFirst(data: T)
    fun insertLast(data: T)
    fun delete(data: T)
    fun search(data: T): Boolean
    fun update(data: T, updatedData: T)
    fun traverse()
}
