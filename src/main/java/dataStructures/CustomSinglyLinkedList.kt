package dataStructures

import dataStructures.interfaces.ISinglyLinkedList

class Node<T>(var data: T) {
    var next: Node<T>? = null
}
class CustomSinglyLinkedList<T>: ISinglyLinkedList<T> {
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

    fun reverseLl() {
        var current = head
        var previous: Node<T>? = null
        while (current != null){
            val nextBkp = current.next  // Save the next node
            current.next = previous  // Reverse the link
            previous = current  // Move one step forward in the list
            current = nextBkp
        }
        head = previous
    }

    fun recursiveReverse(head: Node<T>?): Node<T>? {
        return if (head?.next == null) {
            return head
        } else {
            val nextNode = recursiveReverse(head?.next)
            head?.next?.next = head?.next
            head.next = null
            return nextNode
        }
    }
}

fun hasCycle(head: Node<Int>?): Boolean {
    var slowPointer = head
    var fastPointer = head?.next

    while(fastPointer?.next != null) {
        if (slowPointer == fastPointer) {
            return true
        }
        slowPointer = slowPointer?.next
        fastPointer = fastPointer.next?.next
    }
    return false
}

fun main() {

    val customLinkedList = CustomSinglyLinkedList<Int>()
    customLinkedList.apply {
        insert(1)
        insert(2)
        insert(7)
        insert(3)
        insert(4)

        display()
        reverseLl()
        display()
    }
    var li = mutableListOf<Int>(1, 2, 3)
}

