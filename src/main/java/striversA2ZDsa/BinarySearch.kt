package striversA2ZDsa

import java.awt.desktop.AppHiddenEvent

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

fun searchInsert(nums: IntArray, target: Int): Int {
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
    return low
}

fun findStart(nums: IntArray, target: Int): Int {
    var low = 0
    var high = nums.size - 1
    var result = -1
    while (low <= high) {
        val mid = low + (high - low) / 2
        when{
            nums[mid] == target -> {
                result = mid
                high = mid - 1
            }
            nums[mid] < target -> low = mid + 1
            else -> high = mid - 1
        }
    }
    return result
}

fun findEnd(nums: IntArray, target: Int): Int {
    var low = 0
    var high = nums.size - 1
    var result = -1
    while (low <= high) {
        val mid = low + (high - low) / 2
        when{
            nums[mid] == target -> {
                result = mid
                low = mid + 1
            }
            nums[mid] < target -> low = mid + 1
            else -> high = mid - 1
        }
    }
    return result
}

fun searchRangeOptimised(nums: IntArray, target: Int): IntArray {
    val start = findStart(nums, target)
    val end = findEnd(nums, target)

    return intArrayOf(start, end)
}

fun searchRangeNaive(nums: IntArray, target: Int): IntArray{
    var low = 0
    var high = nums.size - 1
    var targetBool = false
    while (low <= high) {
        val mid = low + (high - low) / 2
        when {
            nums[mid] == target -> {
                targetBool = true
                break
            }
            nums[mid] < target -> low = mid + 1
            else -> high = mid - 1
        }
    }
    return if (targetBool) {
        while (nums[low] != target) {
            low++
        }
        while (nums[high] != target) {
            high--
        }
        intArrayOf(low, high)
    } else {
        intArrayOf(-1, -1)
    }
}

fun occurrenceOfNum(nums: IntArray, target: Int): Int {
    val leftIdx = countLeftOccurrences(nums, target)
    val rightIdx = countRightOccurrences(nums, target)

    if (leftIdx <= rightIdx) {
        return rightIdx - leftIdx + 1
    }
    return 0
}

fun countLeftOccurrences (nums: IntArray, target: Int): Int {
    var low = 0
    var high = nums.size - 1
    var idx = 0
    while (low <= high) {
        val mid = low + (high - low) / 2
        when {
            nums[mid] == target -> {
                idx = mid
                high = mid - 1
            }
            nums[mid] < target -> low = mid + 1
            else -> high = mid - 1
        }
    }

    return idx
}

fun countRightOccurrences (nums: IntArray, target: Int): Int {
    var low = 0
    var high = nums.size - 1
    var idx = 0
    while (low <= high) {
        val mid = low + (high - low) / 2
        when {
            nums[mid] == target -> {
                idx = mid
                low = mid + 1
            }
            nums[mid] < target -> low = mid + 1
            else -> high = mid - 1
        }
    }
    return idx
}

fun searchRotatedArray(nums: IntArray, target: Int): Int{
    var low = 0
    var high = nums.size - 1
    while (low <= high) {
        val mid = low + (high - low) / 2
        when {
            nums[mid] == target -> return mid
            nums[low] <= nums[mid] -> {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1
                } else {
                    low = mid + 1
                }
            }
            nums[mid] <= nums[low] -> {
                if (nums[mid] <= target && target <= nums[high]){
                    low = mid + 1
                } else {
                    high = mid - 1
                }
            }
        }
    }
    return -1
}

fun main() {
    val nums = intArrayOf(7, 8, 9, 1, 2, 3, 4, 5, 6)
    print(searchRotatedArray(nums, 8))
}
