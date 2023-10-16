package techiniques

import dataStructures.CustomStack

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

fun printNto1(a: Int): Int {
    if (a == 1) {
        println(1)
        return 1
    }
    println(a)
    return printNto1(a - 1)
}

fun print1ToN(a: Int, b: Int) {
    if (a == b) {
        println(a)
        return
    }
    println(a)
    print1ToN(a + 1, b)
}

fun sumN(n: Int): Int{
    return if (n == 1) 1 else n + sumN(n - 1)
}

fun fibSeries(n: Int) {
    var li = IntArray(n) {if (it % 2 == 0) 0 else 1}
    when (n) {
        0 -> println(0)
        1 -> println(li)
        else -> {
            for (i in 2 until n) {
                li[i] = (i - 1) + (i - 2)
            }
            println(li.joinToString(", "))
        }
    }
}

fun swap(arr: IntArray, low: Int, high: Int) {
    val temp = arr[low]
    arr[low] = arr[high]
    arr[high] = temp
}

fun reverseArr(arr: IntArray, low: Int, high: Int) {
    if (low > high) {
        return
    }
    swap(arr, low, high)
    reverseArr(arr, low + 1, high - 1)
}

fun main () {
//    val n = readln().toInt()
//    print("SUM : ${sumN(n)}")
//    fibSeries(n)
    var arr = (1..15).sorted().toIntArray()
    println(arr.joinToString(", "))
    reverseArr(arr, 0, arr.size - 1)
    println(arr.joinToString(", "))
}
