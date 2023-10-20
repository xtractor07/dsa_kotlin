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

/**Medium*/
fun twoSum(nums: IntArray, target: Int): IntArray{
    val map = mutableMapOf<Int, Int>()
    for ((idx, value) in nums.withIndex()) {
        val complement = target - value

        map[complement]?.let {
            return intArrayOf(it, idx)
        }
        map[value] = idx
    }
    return intArrayOf(-1, -1)
}

/**Medium*/
fun sortColorsNaive(nums: IntArray) {
    var resultArr = IntArray(nums.size)
    var idx = 0
    for (num in nums) {
        if (num == 0) {
            resultArr[idx] = 0
            idx++
        }
    }
    for (num in nums) {
        if (num == 1) {
            resultArr[idx] = 1
            idx++
        }
    }
    for (num in nums) {
        if (num == 2) {
            resultArr[idx] = 2
            idx++
        }
    }
    for ((index, num) in resultArr.withIndex()) {
        nums[index] = num
    }
}

fun sortColorsOptimized(nums: IntArray) {
    var low = 0
    var high = nums.size - 1
    var current = 0

    while (current <= high) {
        when(nums[current]) {
            0 -> {
                nums[current] = nums[low]
                nums[low] = 0
                low++
                current++
            }
            1 -> {
                current++
            }
            2 -> {
                nums[current] = nums[high]
                nums[high] = 2
                high--
            }
        }
    }
}
fun main() {
//    val arr = (1..100).shuffled().toIntArray()
//    val testArr = intArrayOf(0, 0, 1, 2, 3, 3, 3, 3, 4, 5, 5, 6, 6, 7, 8)
//    val distinctRange = removeDuplicatesFromSorted(testArr)
//    println(testArr.slice(0..distinctRange).joinToString(", "))
//    rotateArrayKTimes(arr, 14)
//    println("${binarySearch(arr, 14)}")
//    mergeSort(arr, 0, arr.size - 1)
//    println("RESULT : ${arr.joinToString (", ")}")
    val nums = intArrayOf(2,0,2,1,1,0)
    sortColorsOptimized(nums)
    println(nums.joinToString(", "))
}
