package dataStructures

import dataStructures.interfaces.IDoublyLinkedList

class DNode<T>(var data: T){
    var next: DNode<T>? = null
    var previous: DNode<T>? = null
}
class DoublyLinkedList<T>: IDoublyLinkedList<T> {

    private var head: DNode<T>? = null
    override fun insertFirst(data: T) {
        val newNode = DNode(data)
        newNode.next = head
        head?.previous = newNode
        head = newNode
    }
    override fun insertLast(data: T) {
        val newNode = DNode(data)
        if (head == null) {
            head = newNode
            return
        }
        var current = head
        while (current?.next != null) {
            current = current.next
        }
        current?.next = newNode
        newNode.previous = current
    }
    override fun delete(data: T) {
        var current = head
        while (current?.next != null) {
            if (current.data == data) {
                current.previous?.next = current.next
                current.next?.previous = current.previous
                if (current == head) {
                    head = current.next
                }
                return
            }
            current = current.next
        }
    }

    override fun search(data: T): Boolean {
        var current = head
        while (current != null) {
            if (current.data == data) break
            current = current?.next
        }
        return current?.data == data
    }

    override fun update(data: T, updatedData: T) {
        var current = head
        if (search(data)) {
            while (current?.data != data) {
                current = current?.next
            }
            current?.data = updatedData
            traverse()
        } else {
            return
        }
    }

    override fun traverse() {
        var current = head
        while (current != null) {
            print("${current.data} -> ")
            current = current.next
        }
        println()
    }
}

fun main() {
    val dll = DoublyLinkedList<Int>()
    dll.apply {
        insertFirst(1)
        insertLast(2)
        insertLast(3)
        insertLast(4)
        insertLast(5)
        traverse()
    }
}
