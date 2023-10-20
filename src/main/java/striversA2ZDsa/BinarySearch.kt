package striversA2ZDsa

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

fun main() {
    val nums = intArrayOf(5, 7, 7, 7, 8, 8, 8, 8, 9, 9, 10, 11, 11)
    print(searchRangeOptimised(nums, 14).joinToString(", "))
}
