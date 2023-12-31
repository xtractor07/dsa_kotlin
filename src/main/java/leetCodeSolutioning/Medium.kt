package leetCodeSolutioning

class Medium {

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
}

fun main() {
    val arr = intArrayOf(1, 2, 3, 4, 5, 7)
    val medium = Medium()
    medium.productExceptSelf(arr).forEach { num ->
        print("$num, ")
    }
}
