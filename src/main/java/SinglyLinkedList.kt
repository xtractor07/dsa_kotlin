class Node<T>(var value: T) {
    var next: Node<T>? = null
}
class SinglyLinkedList<T> {
    private var head: Node<T>? = null

    fun append(value: T){
        if(head == null) {
            head = Node(value)
        } else {
            var current = head
            while (current?.next != null) {
                current = current.next
            }
            current?.next = Node(value)
        }
    }

    fun printList() {
        var current = head
        while(current != null) {
            print("${current.value} -> ")
            current = current.next
        }
        print(null)
    }
}

fun main() {
    val list = SinglyLinkedList<Int>()
    list.append(12)
    list.append(34)
    list.append(45)

    list.printList()
}
