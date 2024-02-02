package leetCodeSolutioning

import algorithms.merge
import striversA2ZDsa.list
import striversA2ZDsa.mutableSet
import techiniques.reverseArr

class Medium {

    fun search(nums: IntArray, target: Int): Int {
        var low = 0
        var high = nums.size - 1

        while (low <= high) {
            val mid = low + (high - low) / 2
            when {
                nums[mid] == target -> return mid
                nums[mid] < target -> low = mid + 1
                else -> high = mid - 1
            }
        }

        return -1
    }

    fun binarySearch(arr: IntArray, target: Int): Boolean {
        var left = 0
        var right = arr.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2

            when {
                arr[mid] == target -> return true
                arr[mid] < target -> left = mid + 1
                else -> right = mid - 1
            }
        }

        return false
    }


    fun mergeSort(arr: IntArray, low: Int, high: Int) {
        if (low < high) {
            val mid = low + (high - low) / 2

            mergeSort(arr, low, mid)
            mergeSort(arr, mid + 1, high)
            merge(arr, low, mid, high)
        }
    }

    private fun merge(arr: IntArray, low: Int, mid: Int, high: Int){
        val n1 = mid - low + 1
        val n2 = high - mid
        val left = IntArray(n1)
        val right = IntArray(n2)

        for (i in 0 until n1) {
            left[i] = arr[low + i]
        }
        for (j in 0 until n2) {
            right[j] = arr[mid + 1 + j]
        }

        var i = 0
        var j = 0
        var k = low

        while (i < n1 && j < n2) {
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

    fun hasPairWithSum(arr: IntArray, target: Int): Boolean {

        var left = 0
        var right = arr.size - 1

        while(left < right) {
            val sum = arr[left] + arr[right]

            if (sum == target) {
                var resultPair = Pair(left, right)
                return true
            } else if(sum < target) {
                left++
            } else {
                right--
            }
        }

        return false
    }

    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.size - 1

        while (left < right) {
            val sum = numbers[left] + numbers[right]
            if(sum == target) {
                return intArrayOf(left + 1, right + 1)
            } else if (sum < target) {
                left++
            } else {
                right--
            }
        }

        return intArrayOf()
    }

    fun sortColors(nums: IntArray): Unit {
        var start = 0
        var end = nums.size - 1
        var idx = 0
        while (idx <= end) {
            when (nums[idx]) {
                0 -> {
                    nums[idx] = nums[start].also { nums[start] = nums[idx] }
                    start++
                    idx++
                }
                2 -> {
                    nums[idx] = nums[end].also { nums[end] = nums[idx] }
                    end--
                }
                else -> idx++
            }
        }
    }

    fun productExceptSelf(nums: IntArray): IntArray {
        val res = IntArray(nums.size) { 1 }
        for(outerIdx in nums.indices) {
            for(innerIdx in nums.indices) {
                if(outerIdx != innerIdx) {
                    res[outerIdx] *= nums[innerIdx]
                }
            }
        }

        return res
    }

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty() || matrix[0].isEmpty()) return false

        var row = 0
        var col = matrix[0].lastIndex

        while (row < matrix.size && col >= 0) {
            when {
                matrix[row][col] == target -> return true
                matrix[row][col] < target -> row++ // Move down if the target is larger
                else -> col-- // Move left if the target is smaller
            }
        }

        return false
    }

    fun findMin(nums: IntArray): Int {
        var low = 0
        var high = nums.size - 1

        // Continue searching while the low pointer is less than or equal to the high pointer.
        while (low < high) {
            val mid = low + (high - low) / 2

            // If the mid element is greater than the high element, the minimum is in the right part.
            if (nums[mid] > nums[high]) {
                low = mid + 1
            } else {
                // Else, the minimum is in the left part or at mid.
                high = mid
            }
        }
        // When low meets high, the minimum is found.
        return nums[low]
    }

    fun findMinHard(nums: IntArray): Int {
        var low = 0
        var high = nums.size - 1

        while(low < high) {
            val mid = low + (high - low) / 2
            when {
                nums[low] == nums[mid] && nums[mid] == nums[high] -> {
                    low++
                    high--
                    continue
                }
                nums[mid] > nums[high] -> {
                    low = mid + 1
                }
                else -> {
                    high = mid
                }
            }
        }

        return nums[low]
    }

    fun twoSumSorted(numbers: IntArray, target: Int): IntArray {
        for(idx in numbers.indices) {
            val complement = target - numbers[idx]
            val j = binarySearch(numbers, complement, idx + 1)
            if(j != -1) {
                return intArrayOf(idx, j)
            }
        }
        return intArrayOf(-1, -1)
    }

    private fun binarySearch(nums: IntArray, target: Int, start: Int): Int {
        var low = start
        var high = nums.size - 1
        while(low <= high) {
            val mid = low + (high - low) / 2
            when {
                nums[mid] == target -> return mid
                nums[mid] < target -> low = mid + 1
                else -> high = mid - 1
            }
        }
        return -1
    }

    fun lengthOfLongestSubstring(s: String): Int {
        var start = 0
        var maxLength = 0
        val seenChars = mutableMapOf<Char, Int>()

        for ((idx, char) in s.withIndex()) {
            if (char in seenChars && seenChars[char]!! >= start) {
                start = seenChars[char]!! + 1
            }
            seenChars[char] = idx
            maxLength = maxOf(maxLength, idx - start + 1)
        }
        return maxLength
    }

    fun sortColorss(nums: IntArray): Unit {
        var low = 0
        var high = nums.size - 1
        var idx = 0
        while (idx <= high) {
            when(nums[idx]) {
                0 -> {
                    nums[idx] = nums[low].also { nums[low] = nums[idx] }
                    low++
                    idx++
                }
                2 -> {
                    nums[idx] = nums[high].also { nums[high] = nums[idx] }
                    high--
                }
                else -> idx++
            }
        }
    }

    fun maxSubArray(nums: IntArray): Int {
        var sum = 0
        var max = -999
        var startIdx = 0
        var endIdx = 0
        for (idx in nums.indices) {
            if (sum == 0) { startIdx = idx }
            sum += nums[idx]
            if (sum > max) {
                max = sum
                endIdx = idx
            }
            if (sum < 0) {
                sum = 0
            }
        }

        print(Pair(startIdx, endIdx))
        return if (max < 0) 0 else {
            max
        }
    }

    fun rearrangeArray(nums: IntArray): IntArray {
        val result = mutableListOf<Int>()
        val positive = nums.filter { it > 0 }
        val negative = nums.filter { it < 0 }

        var pos = 0
        var neg = 0
        for(idx in nums.indices) {
            if (idx % 2 == 0) {
                result.add(positive[pos])
                pos++
            } else {
                result.add(negative[neg])
                neg++
            }
        }
        return result.toIntArray()
    }

    fun nextPermutation(nums: IntArray): Unit {
        var idx = -1
        val size = nums.size

        for (ptr in size - 2 downTo  0) {
            if (nums[ptr] < nums[ptr + 1]) {
                idx = ptr
                break
            }
        }

        if (idx == -1) {
            nums.reverse()
        }

        for (ptr in size - 1 downTo idx + 1) {
            if (nums[ptr] > nums[idx]) {
                nums[ptr] = nums[idx].also { nums[idx] = nums[ptr] }
                break
            }
        }
        reverseArr(nums, idx + 1, size - 1)
    }

    fun leadersInArray(nums: IntArray): IntArray {
        val leaders = mutableListOf<Int>()
        var max = Int.MIN_VALUE
        for (idx in nums.size - 1 downTo 0) {
            if (nums[idx] > max) {
                max = nums[idx]
                leaders.add(max)
            }
        }

        leaders.reverse()

        return leaders.toIntArray()
    }

    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        mergeSort(nums, 0, nums.size - 1)
        var count = 1
        var maxCount = 1

        for (idx in 1 until nums.size) {
            if (nums[idx] != nums[idx - 1]) {
                if (nums[idx] == nums[idx - 1] + 1) {
                    count++
                } else {
                    maxCount = maxOf(maxCount, count)
                    count = 1
                }
            }
        }
        maxCount = maxOf(maxCount, count)

        return maxCount
    }

    fun setZeroes(matrix: Array<IntArray>): Unit {
//        val zeroRows = mutableSetOf<Int>()
//        val zeroCols = mutableSetOf<Int>()


        var col0 = 1
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0
                    if (j != 0) {
                        matrix[0][j] = 0
                    } else {
                        col0 = 0
                    }
                }
            }
        }

        for (i in 1..< matrix.size) {
            for (j in 1 ..< matrix[i].size) {
                if (matrix[i][j] != 0) {
                    if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0
                    }
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (j in matrix[0].indices) matrix[0][j] = 0
        }
        if (col0 == 0) {
            for (i in matrix.indices) matrix[i][0] = 0
        }

        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                print(matrix[i][j])
            }

            println()
        }

//        for (row in zeroRows) {
//            for (j in matrix[row].indices) {
//                matrix[row][j] = 0
//            }
//        }
//
//        for (col in zeroCols) {
//            for (i in matrix.indices) {
//                matrix[i][col] = 0
//            }
//        }
    }

    fun rotate(matrix: Array<IntArray>): Array<IntArray> {
        val n = matrix.size
        //Transpose the matrix
        for (i in 0 until n) {
            for (j in 0 until n) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }

        for (i in 0 until n) {
            for (j in 0 until n / 2) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[i][n - 1 - j]
                matrix[i][n - 1 - j] = temp
            }
        }

        return matrix
    }

    fun subarraySum(nums: IntArray, k: Int): Int {
        var count = 0
        var sum = 0
        val sumFrequency = hashMapOf<Int, Int>()
        sumFrequency[0] = 1

        for (num in nums) {
            sum += num
            count += sumFrequency.getOrDefault(sum - k, 0)
            sumFrequency[sum] = sumFrequency.getOrDefault(sum, 0) + 1
        }

        return count
    }

}

fun main() {
    val arr = intArrayOf(1, 2, 3, 4, 5, 7)
    var arr1: IntArray = (1..100).shuffled().toIntArray()
    var arr2 = intArrayOf(-2,1,-3,4,-1,2,1,-5,4)
    var arr3 = intArrayOf(100,4,200,1,3,2)
    val matrix = arrayOf(intArrayOf(1, 3, 5, 7), intArrayOf(10, 11, 16, 20), intArrayOf(23, 30, 34, 60))
    val mat2 = arrayOf(intArrayOf(1), intArrayOf(3))
    val s = "pwwkew"
    val medium = Medium()
    val arr4 = arrayOf(intArrayOf(1,1,1), intArrayOf(1,0,1), intArrayOf(1,1,1))
    val arr5 = arrayOf(intArrayOf(1,2,3,4), intArrayOf(5,0,7,8), intArrayOf(0,10,11,12), intArrayOf(13,14,15,0))
    val arr6 = intArrayOf(3, 1, 2, 4)
//    val arr3 = intArrayOf(2,7,11,15)
//    medium.mergeSort(arr1, 0, arr1.size - 1)
//    val matrix1 = medium.rotate(arr5)
    print(medium.subarraySum(arr6, 6))
}
