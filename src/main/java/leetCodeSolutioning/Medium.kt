package leetCodeSolutioning

import algorithms.merge

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


}

fun main() {
    val arr = intArrayOf(1, 2, 3, 4, 5, 7)
    var arr1: IntArray = (1..100).shuffled().toIntArray()
    var arr2 = intArrayOf(-2,1,-3,4,-1,2,1,-5,4)
    val matrix = arrayOf(intArrayOf(1, 3, 5, 7), intArrayOf(10, 11, 16, 20), intArrayOf(23, 30, 34, 60))
    val mat2 = arrayOf(intArrayOf(1), intArrayOf(3))
    val s = "pwwkew"
    val medium = Medium()
    val arr3 = intArrayOf(2,7,11,15)
//    medium.mergeSort(arr1, 0, arr1.size - 1)
    medium.maxSubArray(arr2)
}
