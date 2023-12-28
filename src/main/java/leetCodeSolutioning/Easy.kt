package leetCodeSolutioning

import kotlin.math.abs
import kotlin.math.max

class Easy {
    fun alterMerge(word1: String, word2: String): String {
        var finalString = ""
        val mainString = StringBuilder(if (word1.length > word2.length) word1 else word2)
        val idx = if (word1.length < word2.length) word1.length else word2.length
        for (i in 0 until idx) {
            finalString += word1[i].toString() + word2[i].toString()
            if (mainString.isNotEmpty()) {
                mainString.deleteCharAt(0)
            }
        }
        finalString += mainString
        return finalString
    }

    fun gcdStrings(str1: String, str2: String): String {
        if (str1 + str2 != str2 + str1) {
            return ""
        }
        if (str1 == str2) {
            return str1
        }
        if (str1.length > str2.length) {
            return gcdStrings(str2, str1)
        }
        if (str2.startsWith(str2)) {
            return gcdStrings(str1, str2.substring(str1.length))
        }
        return ""
    }

    fun kidsWithCandies(candies: List<Int>, extraCandies: Int): List<Boolean> {
        val result = mutableListOf<Boolean>()
        val max = candies.max()
        val min = candies.min()
        if ((candies.size >= 2) && (candies.size <= 100) && (min >= 1) && (max <= 100) && (extraCandies <= 50) && (extraCandies >= 1)) {
            for (i in candies) {
                if (((i + extraCandies) >= max)) {
                    result.add(true)
                } else {
                    result.add(false)
                }
            }
        }
        return result
    }

    fun canPlaceFlowers(flowerbed: List<Int>, n: Int): Boolean {
        var internalCount = 0
        var nCopy = n
        if ((flowerbed.size <= 2 * (10 * 10 * 10 * 10)) && n <= flowerbed.size) {
            for (element in flowerbed) {
                if (element == 0) {
                    internalCount += 1
                }
                if (internalCount == 3) {
                    nCopy -= 1
                    internalCount = 1
                }
                if (nCopy == 0) {
                    return true
                }
            }
        }
        return false
    }

/*    fun reverseVowels(s: String): String {

        val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        val arr = s.toCharArray()
        var start = 0
        var end = s.length - 1

        while (start < end) {
            if (arr[start].lowercaseChar() in vowels && arr[end].lowercaseChar() in vowels) {
                val temp = arr[start]
                arr[start] = arr[end]
                arr[end] = temp

                start++
                end--
            } else if (arr[start].lowercaseChar() !in vowels) {
                start++
            } else if (arr[end].lowercaseChar() !in vowels) {
                end--
            }
        }

        return String(arr)
    }*/

    fun reverseString(s: CharArray): String {
        var start = 0
        var end = s.size - 1

        while (start < end) {

            val temp = s[start]
            s[start] = s[end]
            s[end] = temp

            start++
            end--
        }

        return String(s)
    }

    fun reverseStr(s: String, k: Int): String {
        var splitStr = s.slice(0 until k).toCharArray()
        var otherPiece = s.slice(k until s.length)
        var start = 0
        var end = splitStr.size - 1
        while (start < end) {
            val temp = splitStr[start]
            splitStr[start] = splitStr[end]
            splitStr[end] = temp

            start++
            end--
        }

        return String(splitStr) + otherPiece
    }

    fun reverseWordsChar(s: String): Any {
        var processing = s.split(" ".toRegex()).toMutableList()
        var word = ""
        for ((count, element) in processing.withIndex()) {
            var result = element.toCharArray()
            var start = 0
            var end = element.length - 1
            while (start < end) {
                val temp = result[start]
                result[start] = result[end]
                result[end] = temp

                start++
                end--
            }
            processing[count] = String(result)
        }
        return processing.joinToString(separator = " ")
    }

/*    fun reverseWords(s: String): String {
        var processingList = s.split("\\s+".toRegex()).toMutableList()
//        var word = ""
//        var idx = 0
//        for (element in s) {
//            if (element != ' ') {
//                word += element
//            } else {
//                processingList.add(word)
//                word = ""
//                processingList.add(element.toString())
//            }
//        }
//        // Add the last word if it exists
//        if (word.isNotEmpty()) {
//            processingList.add(word)
//        }
        var start = 0
        var end = processingList.size - 1
        while (start < end) {
            val temp = processingList[start]
            processingList[start] = processingList[end]
            processingList[end] = temp

            start++
            end--
        }

        return processingList.joinToString(separator = " ").trim()
    }*/

    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size

        // Step 1: Initialize left and right arrays
        val left = IntArray(n) { 1 }
        val right = IntArray(n) { 1 }

        // Step 2: Populate left array
        var leftProduct = 1
        for (i in 0 until n) {
            left[i] = leftProduct
            leftProduct *= nums[i]
        }

        // Step 3: Populate right array
        var rightProduct = 1
        for (i in n - 1 downTo 0) {
            right[i] = rightProduct
            rightProduct *= nums[i]
        }

        // Step 4: Calculate the final answer array
        val answer = IntArray(n)
        for (i in 0 until n) {
            answer[i] = left[i] * right[i]
        }

        return answer
    }

    fun moveZeroes(nums: IntArray): Unit {
        var nonZeroIndex = 0
        for (idx in nums.indices) {
            if (nums[idx] != 0) {
                val temp = nums[idx]
                nums[idx] = nums[nonZeroIndex]
                nums[nonZeroIndex] = temp

                nonZeroIndex++
            }
        }
    }

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var p1 = m - 1
        var p2 = n - 1

        var p = m + n - 1

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] < nums2[p2]) {
                nums1[p] = nums2[p2]
                p2--
            } else {
                nums1[p] = nums1[p1]
                p1--
            }
            p -= 1
        }

        while (p2 >= 0) {
            nums1[p] = nums2[p2]
            p--
            p2--
        }
    }

    fun removeElement(arr: IntArray, `element`: Int): Int {
        var length = arr.size
        var i = 0
        while (i < length) {
            if (arr[i] == element) {
                // Shift all elements from (i+1) to (length - 1)
                for (j in i until length - 1) {
                    arr[j] = arr[j + 1]
                }
                length--  // Reduce effective length of array
            } else {
                i++  // Only increase i if no shifting was performed
            }
        }
        return length
    }

    fun majorityElement(nums: IntArray): Int {
        var frequencyMap = mutableMapOf<Int, Int>()
        var count = 1
        for (idx in nums.indices) {
            if (nums[idx] in frequencyMap) {
                count++
                frequencyMap[nums[idx]] = count
            } else {
                count = 1
                frequencyMap[nums[idx]] = count
            }
        }
        var max = 0
        for ((key, value) in frequencyMap) {
            if (value > max) {
                max = key
            }
        }
        return max
    }

    fun findDuplicate(nums: IntArray): Int {
        var frequencyMap = mutableMapOf<Int, Int>()
        var count = 1
        var result = -1
        for (idx in nums.indices) {
            if (nums[idx] in frequencyMap) {
                count += 1
                frequencyMap[nums[idx]] = count
            } else {
                count = 1
                frequencyMap[nums[idx]] = count
            }
        }

        for ((key, value) in frequencyMap) {
            if (value == 2) {
                result = key
            }
        }

        return result
    }

    fun arraySign(nums: IntArray): Int {
        return if (0 !in nums) {
            var negativeCount = 0
            nums.sort()
            for (idx in nums.indices) {
                if (nums[idx] < 0) {
                    negativeCount++
                } else {
                    break
                }
            }
            if (negativeCount % 2 == 0) 1 else -1
        } else {
            0
        }
    }

    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val answer = mutableListOf<List<Int>>()
        var tempList = mutableListOf<Int>()
        for (i in nums1.indices) {
            if (nums1[i] !in nums2) {
                tempList.add(nums1[i])
            }
        }
        answer.add(tempList.distinct())
        tempList = mutableListOf()
        for (j in nums2.indices) {
            if (nums2[j] !in nums1) {
                tempList.add(nums2[j])
            }
        }
        answer.add(tempList.distinct())

        return answer
    }

    fun diagonalSum(mat: Array<IntArray>): Int {
        val n = mat.size
        var sum = 0
        for (idx in 0 until n) {
            sum += if (idx == n - 1 - idx) {
                mat[idx][idx]
            } else {
                mat[idx][idx] + mat[idx][n - 1 - idx]
            }
        }
        return sum
    }

    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        if (coordinates.size < 3) return true
        val (x0, y0) = coordinates[0]
        val (x1, y1) = coordinates[1]

        val dx = x1 - x0
        val dy = y1 - y0
        for (element in coordinates) {
            val (xi, yi) = element
            if (dx * (yi - y0) != dy * (xi - x0)) {
                return false
            }
        }
        return true
    }

    fun mergeSort(arr: IntArray, low: Int, high: Int): Unit {
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

    fun sortedSquares(nums: IntArray): IntArray {
        var low = 0
        var high = nums.size - 1
        var index = nums.size - 1
        var result = IntArray(nums.size)

        while (low <= high) {
            if (abs(nums[low]) < abs(nums[high])) {
                result[index] = nums[high] * nums[high]
                high--
            } else {
                result[index] = nums[low] * nums[low]
                low++
            }
            index--
        }

        return result
    }

    fun missingNumber(nums: IntArray): Int {
        val expectedSum = (nums.size * (nums.size + 1)) / 2
        val actualSum = nums.sum()
        return expectedSum - actualSum
    }

    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        if (nums.isEmpty()) return 0  // Handling empty array

        var maxConCount = 0
        var currentCount = 0

        for (i in nums.indices) {
            if (nums[i] == 1) {
                currentCount++
                maxConCount = maxOf(maxConCount, currentCount)
            } else {
                currentCount = 0
            }
        }
        return maxConCount
    }

    fun singleNumber(nums: IntArray): Int {
        return if (nums.isNotEmpty()) {
            var freqMap = mutableMapOf<Int, Int>()
            for (num in nums) {
                freqMap[num] = freqMap.getOrDefault(num, 0) + 1
            }
            freqMap.filter { it.value == 1 }.keys.min()
        } else -1
    }

    fun getConcatenation(nums: IntArray): IntArray {
        val n = nums.size
        val resArray = IntArray(2 * n)
        for (idx in nums.indices) {
            resArray[idx] = nums[idx]
            resArray[n + idx] = nums[idx]
        }
        return resArray
    }

    fun numIdenticalPairs(nums: IntArray): Int {
        val countMap = HashMap<Int, Int>()
        var goodPairs = 0
        nums.forEach {num ->
            val count = countMap.getOrDefault(num, 0)
            goodPairs += count
            countMap[num] = count + 1
        }

        return goodPairs
    }

    fun mergeAlternately(word1: String, word2: String): String {
        val res = StringBuilder()
        val minLength = minOf(word1.length, word2.length)
        for (i in 0 until minLength) {
            res.append(word1[i])
            res.append(word2[i])
        }
        if (minLength < word1.length) {
            res.append(word1.substring(minLength))
        } else {
            res.append((word2.substring(minLength)))
        }

        return res.toString()
    }

    fun gcdOfStrings(str1: String, str2: String): String {
        fun gcd(a: Int, b: Int): Int {
            return if (b == 0) a else gcd(b, a % b)
        }

        if (str1 + str2 != str2 + str1) {
            return ""
        }
        val gcdLength = gcd(str1.length, str2.length)

        return str1.substring(0, gcdLength)
    }

    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        /**Bruteforce Approach*/
        /*val result = mutableListOf<Boolean>()
        val max = candies.max()
        for (idx in candies.indices) {ooi
            if (candies[idx] + extraCandies >= max) {
                result.add(true)
            } else {
                result.add(false)
            }
        }
        return result*/
        /**Optimised Approach*/
        val max = candies.max()
        return candies.map { it + extraCandies >= max }
    }

    fun reverseVowels(s: String): String {
        var low = 0
        var high = s.length - 1
        val charArray = s.toCharArray()
        val vowels = listOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        while (low < high) {
            while (low < high && charArray[low] !in vowels) {
                low++
            }
            while (low < high && charArray[high] !in vowels) {
                high--
            }
            if (charArray[low] in vowels && charArray[high] in vowels) {
                charArray[low] = charArray[high].also { charArray[high] = charArray[low] }
                low++
                high--
            }
        }
        return String(charArray)
    }

    fun reverseWords(s: String): String {
        val charArray = s.toCharArray()
        val stringList = mutableListOf<String>()
        var temp = ""

        for (char in charArray) {
            if (char != ' ') {
                temp += char
            } else if (temp.isNotEmpty()) {
                stringList.add(temp)
                temp = ""
            }
        }

        if (temp.isNotEmpty()) {
            stringList.add(temp)
        }

        val result = stringList.reversed().joinToString(separator = " ")
        return result
    }
}

fun main() {
    val nums = intArrayOf(1,2,1)
    val input1 = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4), intArrayOf(4, 5), intArrayOf(5, 6), intArrayOf(6, 7))
    val input2 = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 5))
    val unsortedArray: IntArray = (1..100).shuffled().toIntArray()
    val input3 = intArrayOf(-4, 0, 3, 10, -1).toList().shuffled().toIntArray()
    val testString = "the sky is blue"
    val easy = Easy()
//    easy.mergeSort(unsortedArray, 0, unsortedArray.size - 1)
    print(easy.reverseWords(testString))
}

