import dataStructures.CustomQueue

class QueueProblems {

    fun reverseFirstKElements(testQueue: CustomQueue<Int>, k: Int): CustomQueue<Int> {
        val tempList = mutableListOf<Int>()
        for(i in 0 until k) {
            testQueue.dequeue()?.let { tempList.add(it) }
        }
        while (tempList.isNotEmpty()) {
            testQueue.enqueue(tempList.removeAt(tempList.size - 1))
        }
        val size = testQueue.size()
        for (i in  0 until size - k) {
            testQueue.dequeue()?.let { testQueue.enqueue(it) }
        }
        return testQueue
    }
}

fun main() {
    val queueProblems = QueueProblems()
    var testQueue = CustomQueue<Int>()
    testQueue.enqueue(1)
    testQueue.enqueue(2)
    testQueue.enqueue(3)
    testQueue.enqueue(4)
    testQueue.enqueue(5)
    testQueue.printQueue()
    testQueue = queueProblems.reverseFirstKElements(testQueue, 3)
    testQueue.printQueue()
}
