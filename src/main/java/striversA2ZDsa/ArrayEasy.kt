package striversA2ZDsa

fun largestElement(arr: IntArray): Int {
    var low = 0
    var high = arr.size - 1
    var max = 0
    while (low < high) {
        if (arr[low] > max) {
            max = arr[low]
        }
        if (arr[high] > max){
            max = arr[high]
        }
        high--
        low++
    }
    return max
}

fun sortedCheck(arr: IntArray): Boolean {
    return arr.min() == arr[0]
}

fun removeDuplicatesFromSorted(arr: IntArray): Int {
    var idx = 0
    for (i in 1 until arr.size) {
        if (arr[i - 1] != arr[i]) {
            idx++
            arr[idx] = arr[i]
        }
    }
    return idx
}

fun rotateArraySingleTimeBrute(arr: IntArray) {
    val temp = IntArray(arr.size)
    for ( i in 1 until arr.size) {
        temp[i - 1] = arr[i]
    }
    temp[arr.size - 1] = arr[0]
    print(temp.joinToString(", "))
}

fun rotateArraySingleTimeOptimised(arr: IntArray) {
    val temp = arr[0]
    for (i in 0 until arr.size - 1) {
        arr[i] = arr[i + 1]
    }
    arr[arr.size - 1] = temp
}

fun rotateArrayKTimes(arr: IntArray, k: Int) {
    val temp = IntArray(k)
    val negCheck = k % arr.size
    for (i in 0 until negCheck) {
        temp[i] = arr[i]
    }
    for (i in 0 until arr.size - negCheck){
        arr[i] = arr[i + negCheck]
    }
    for (i in arr.size - negCheck until arr.size) {
        arr[i] = temp[i - arr.size + negCheck]
    }
}

fun binarySearch(arr: IntArray, target: Int): Int {
    var low = 0
    var high = arr.size - 1
    while (low <= high) {
        val mid = low + (high - low)  / 2

        when{
            arr[mid] == target -> return mid
            arr[mid] > target -> high = mid - 1
            else -> low = mid + 1
        }
    }
    return -1
}

fun mergeSort(arr: IntArray, low: Int, high: Int) {
    if (low < high) {
        val mid = low + (high - low) / 2
        mergeSort(arr, low, mid)
        mergeSort(arr, mid + 1, high)
        merge(arr, low, mid, high)
    }
}

fun merge(arr: IntArray, low: Int, mid: Int, high: Int) {
    val n1 = mid - low + 1
    val n2 = high - mid
    var left = IntArray(n1)
    var right = IntArray(n2)

    for (i in 0 until n1) {
        left[i] = arr[low + i]
    }
    for (j in 0 until n2) {
        right[j] = arr[j + mid + 1]
    }

    var i = 0
    var j = 0
    var k = low

    while (i < n1 && j < n2) {
        if (left[i] <= right[j]) {
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

fun main() {
    val arr = (1..100).shuffled().toIntArray()
    val testArr = intArrayOf(0, 0, 1, 2, 3, 3, 3, 3, 4, 5, 5, 6, 6, 7, 8)
//    val distinctRange = removeDuplicatesFromSorted(testArr)
//    println(testArr.slice(0..distinctRange).joinToString(", "))
//    rotateArrayKTimes(arr, 14)
//    println("${binarySearch(arr, 14)}")
    mergeSort(arr, 0, arr.size - 1)
    println("RESULT : ${arr.joinToString (", ")}")
}
