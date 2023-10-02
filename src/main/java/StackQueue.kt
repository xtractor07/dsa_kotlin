import dataStructures.CustomStack

class StackQueue <T> {

    private val stack1 = CustomStack<T>()
    private val stack2 = CustomStack<T>()

    fun enqueue(item: T) {
        stack1.push(item)
    }

    fun dequeue(): T? {

        // If both stacks are empty, the queue is empty
        if (isEmpty()) {
            println("Queue is empty")
            return null
        }

        // If stack2 is empty, transfer all elements from stack1 to stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack1.pop()?.let { stack2.push(it) }
            }
        }

        return stack2.pop()
    }

    private fun isEmpty() = stack1.isEmpty() && stack2.isEmpty()
}

fun main() {
    val queue = StackQueue<Int>()
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)
    println(queue.dequeue())  // Outputs: 1
    println(queue.dequeue())  // Outputs: 2
    queue.enqueue(4)
    println(queue.dequeue())  // Outputs: 3
}






