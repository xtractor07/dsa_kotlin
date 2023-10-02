package algorithms

import kotlin.system.measureTimeMillis

fun binarySearch(arr: IntArray, target: Int): Int{
    var low = 0
    var high = arr.size - 1

    while(low <= high) {
        val mid = low + (high - low) / 2

        when{
            arr[mid] == target -> return mid // Element found
            arr[mid] < target -> low = mid + 1 // Search right
            else -> high = mid - 1 // Search left
        }
    }

    return -1
}

fun mergeSort(arr: IntArray, low: Int, high: Int) {
    if(low < high) {
        val mid = low + (high - low) / 2

        mergeSort(arr, low, mid)
        mergeSort(arr, mid + 1, high)
        merge(arr, low, mid, high)
    }
}

fun merge(arr: IntArray, low: Int, mid: Int, high: Int) {
    val n1 = mid - low + 1
    val n2 = high - mid

    val left = IntArray(n1)
    val right = IntArray(n2)

    for (i in 0 until n1) {
        left[i] = arr[low + i]
    }
    for (j in  0 until n2) {
        right[j] = arr[mid + 1 + j]
    }

    var i = 0
    var j= 0
    var k = low

    while(i < n1 && j < n2) {
        if (left[i] < right[j]) {
            arr[k] = left[i]
            i++
        } else {
            arr[k] = right[j]
            j++
        }
        k++
    }

    while (i < n1) {
        arr[k] = left[i]
        i++
        k++
    }

    while (j < n2) {
        arr[k] = right[j]
        j++
        k++
    }
}

fun bubbleSort(arr: IntArray) {
    val n = arr.size
    var swapped: Boolean

    for (i in 0 until n) {
        swapped = false
        for (j in 0 until n - 1 - i) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
                swapped = true
            }
        }
        if (!swapped) break
    }
}

fun quickSort(arr: IntArray, low: Int, high: Int) {
    if(low < high) {
        val pi = partition(arr, low, high)

        quickSort(arr, low, pi - 1)
        quickSort(arr, pi + 1, high)
    }
}

fun partition(arr: IntArray, low: Int, high: Int): Int {
    val pivot = arr[high]
    var idx = low - 1

    for (j in low until high) {
        if (arr[j] <= pivot) {
            idx ++

            val temp = arr[idx]
            arr[idx] = arr[j]
            arr[j] = temp
        }
    }

    val temp = arr[idx + 1]
    arr[idx + 1] = arr[high]
    arr[high] = temp

    return idx + 1
}


fun sortArray(arr: IntArray){
    for (i in arr.indices) {
        for (j in arr.indices){
            if(i != j && arr[j] > arr[i]){
                val temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
            }
        }
    }
}

fun main() {
    var nums = intArrayOf(2, 3, 5, 7, 8, 10, 12, 15, 18, 20)
//    val unsortedArray1: IntArray = (1..100).shuffled().toIntArray()
    val unsortedArray2: IntArray = (1..100000000).shuffled().toIntArray()
//    val unsortedArray3: IntArray = (1..100000).shuffled().toIntArray()
    val arr = intArrayOf(3, 3, 2, 2)
//    mergeSort(arr, 0, arr.size - 1)
//    println("TARGET AT IDX: ${arr.joinToString(" ,")}")
//    mergeSort(unsortedArray, 0, unsortedArray.size - 1)
//    quickSort(unsortedArray1, 0, unsortedArray1.size - 1)
//    println(unsortedArray1.joinToString(", "))
//    val bubbleSortTime = measureTimeMillis { bubbleSort(unsortedArray3) }
//    val mergeSortTime = measureTimeMillis { mergeSort(unsortedArray1, 0, unsortedArray1.size - 1) }
    val quickSortTime = measureTimeMillis { quickSort(unsortedArray2, 0, unsortedArray2.size - 1) }
    println("MERGE-SORT: \n" +
            "QUICK-SORT: $quickSortTime\n" +
            "BUBBLE-SORT: ")

}
