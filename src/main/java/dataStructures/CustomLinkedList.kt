package dataStructures

import dataStructures.interfaces.ILinkedList

class Node<T>(var data: T) {
    var next: Node<T>? = null
}
class CustomLinkedList<T>: ILinkedList<T> {
    private var head: Node<T>? = null
    override fun insert(data: T) {
        val newNode = Node(data)
        if (head == null) {
            head = newNode
        } else{
            var current = head
            while (current?.next != null) {
                current = current.next
            }
            current?.next = newNode
        }
    }

    override fun delete(data: T) {
        if (head == null) return

        if (head?.data == data) {
            head = head?.next
            return
        }

        var current = head
        while (current?.next != null && current.next?.data != data) {
            current = current.next
        }

        if (current?.next != null) {
            current.next = current.next?.next
        }
    }

    override fun display() {
        var current = head
        while (current != null) {
            print("${current.data} -> ")
            current = current.next
        }
        println()
    }

    fun search(data: T): Boolean {
        if (head == null) return false

        if (head?.data == data) return true

        var current = head
        while (current?.next != null) {
            if (current.data == data) break
            current = current?.next
        }
        return current?.data == data
    }

    fun size(): Int {
        var current = head
        var size = 1
        while (current?.next != null) {
            size++
            current = current?.next
        }
        return size
    }
}

fun main() {

    val customLinkedList = CustomLinkedList<Int>()
    customLinkedList.apply {
        insert(1)
        insert(2)
        insert(7)
        insert(3)
        insert(4)
        println("RESULT : ${search(10)}")
        insert(10)
        println("RESULT : ${search(10)}")
    }
}

