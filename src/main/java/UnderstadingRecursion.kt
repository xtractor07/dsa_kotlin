import java.util.Stack

fun countDown(n: Int) {
    if(n <= 0) {  /**Base condition: n <= 0*/
        println ("Done!")
    } else {
        println(n)
        countDown(n - 1)    /** Recursive case: Calling countDown(n - 1)*/
    }
}

fun factorial(n: Int): Int {
    return if(n <= 1) {
        1
    } else {
        n * factorial(n-1)
    }
}

fun fibonacciSequence(n: Int): Int{
    if (n <= 1) return n
    return fibonacciSequence(n - 1) + fibonacciSequence(n - 2)
}

fun printFibonacciSequence(n: Int) {
    for (i in 0..n) {
        print("${fibonacciSequence(i)} ")
    }
}

fun arraySum(array: IntArray, idx: Int): Int {
    return if(idx == array.size) {
        0
    }else {
        array[idx] + arraySum(array, idx + 1)
    }
}

fun palindromeChecker(string: String, lastIdx: Int): String {
    return if(lastIdx == 0) {
        string[0].toString()
    }else {
        string[lastIdx] + palindromeChecker(string, lastIdx - 1)
    }
}

// Recursive function to pop all items from the stack
fun <T> reverseStack(stack: CustomStack<T>) {
    if (stack.isEmpty()) return
    val item = stack.pop()!!
    reverseStack(stack)
    insertAtBottom(stack, item)
}

// Recursive function to insert an item at the bottom of the stack
fun <T> insertAtBottom(stack: CustomStack<T>, item: T) {
    if (stack.isEmpty()) {
        stack.push(item)
        return
    }
    val temp = stack.pop()!!
    insertAtBottom(stack, item)
    stack.push(temp)
}

fun rotateArray(arr: IntArray, d:Int): IntArray {
    val n = arr.size
    val temp = IntArray(d)

    for (i in 0 until d) {
        temp[i] = arr[i]
    }
    for (i in d until n) {
        arr[i - d] = arr[i]
    }
    for (i in 0 until d) {
        arr[n - d + i] = temp[i]
    }

    return arr
}
fun main () {
    val array = intArrayOf(1, 2, 3, 4, 5)
    println(rotateArray(array, 2).joinToString(", "))
}
