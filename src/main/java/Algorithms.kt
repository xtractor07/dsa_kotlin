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
        val mid = (low + high) / 2
        mergeSort(arr, low, mid)
        mergeSort(arr, mid + 1, high)
        merge(arr, low, mid, high)
    }
}

fun merge(arr: IntArray, low: Int, mid: Int, high: Int){
    val n1 = mid - low + 1
    val n2 = high - mid

    val left = IntArray(n1)
    val right = IntArray(n2)

    for (i in 0 until n1) { /** Populate left array*/
        left[i] = arr[low + i]
    }

    for (j in 0 until n2) { /** Populate right array*/
        right[j] = arr[mid + 1 +j]
    }

    var i = 0
    var j = 0
    var k = low

    while(i < n1 && j < n2){ /** Compare and generate sorted array*/
        if(left[i] <= right[j]){
            arr[k] = left[i]
            i++
        }
        else{
            arr[k] = right[j]
            j++
        }
        k++
    }

    while(i < n1) {
        arr[k] = left[i]
        i++
        k++
    }

    while (j < n2){
        arr[k] = right[j]
        j++
        k++
    }
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
    val unsortedArray: IntArray = (1..10000).shuffled().toIntArray()
    val unsortedArrayCopy: IntArray = (1..10000).shuffled().toIntArray()
    val mergeSortTime = measureTimeMillis { mergeSort(unsortedArray, 0, unsortedArray.size - 1) }
    val normalSortTime = measureTimeMillis { sortArray(unsortedArrayCopy) }
    println("MERGE-SORT: $mergeSortTime\n" +
            "BRUTE-SORT: $normalSortTime")

}
