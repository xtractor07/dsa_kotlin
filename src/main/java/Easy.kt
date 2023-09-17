import kotlin.system.exitProcess

class Easy {
    fun alterMerge(word1: String, word2: String): String{
        var finalString = ""
        val mainString = StringBuilder(if (word1.length > word2.length ) word1 else word2)
        val idx = if (word1.length < word2.length ) word1.length else word2.length
        for (i in 0 until idx) {
            finalString += word1[i].toString() + word2[i].toString()
            if(mainString.isNotEmpty()){
                mainString.deleteCharAt(0)
            }
        }
        finalString += mainString
        return finalString
    }

    fun gcdStrings(str1: String, str2: String): String{
        if (str1+str2 != str2+str1){
            return ""
        }
        if (str1 == str2){
            return str1
        }
        if (str1.length > str2.length){
            return gcdStrings(str2, str1)
        }
        if(str2.startsWith(str2)){
            return gcdStrings(str1, str2.substring(str1.length))
        }
        return ""
    }

    fun kidsWithCandies(candies: List<Int>, extraCandies: Int): List<Boolean> {
        val result = mutableListOf<Boolean>()
        val max = candies.max()
        val min = candies.min()
        if ((candies.size >= 2) && (candies.size <= 100) && (min >= 1) && (max <= 100) && (extraCandies <= 50) && (extraCandies >= 1)){
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
        if ((flowerbed.size <= 2 * (10 * 10 * 10 * 10)) && n <= flowerbed.size){
            for (element in flowerbed) {
                if (element == 0) {
                    internalCount += 1
                }
                if(internalCount == 3){
                    nCopy -= 1
                    internalCount = 1
                }
                if(nCopy == 0){
                    return true
                }
            }
        }
        return false
    }

    fun reverseVowels(s: String): String {

        val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        val arr = s.toCharArray()
        var start = 0
        var end  = s.length - 1

        while(start < end) {
            if(arr[start].lowercaseChar() in vowels && arr[end].lowercaseChar() in vowels) {
                val temp = arr[start]
                arr[start] = arr[end]
                arr[end] = temp

                start++
                end--
            }
            else if (arr[start].lowercaseChar() !in vowels){
                start++
            }
            else if (arr[end].lowercaseChar() !in vowels){
                end--
            }
        }

        return String(arr)
    }

    fun reverseString(s: CharArray): String {
        var start = 0
        var end = s.size - 1

        while(start < end) {

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
        while (start < end){
            val temp = splitStr[start]
            splitStr[start] = splitStr[end]
            splitStr[end] = temp

            start++
            end--
        }

        return String(splitStr) + otherPiece
    }

    fun reverseWordsChar(s: String) : Any {
        var processing = s.split(" ".toRegex()).toMutableList()
        var word = ""
        for ((count, element) in processing.withIndex()) {
            var result = element.toCharArray()
                var start = 0
                var end = element.length - 1
                while (start < end){
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

    fun reverseWords(s: String): String {
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
    }

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
        for (idx in nums.indices){
            if(nums[idx] != 0) {
                val temp = nums[idx]
                nums[idx] = nums[nonZeroIndex]
                nums[nonZeroIndex] = temp

                nonZeroIndex++
            }
        }
    }

}

fun main() {
    val w1 = "ab"
    val w2 = "pqrs"
    val str1 = "LEET"
    val str2 = "CODE"
    val candies = listOf(4,2,1,1,2)
    val extraCandies = 1
    val testString = "  hello world  "
    val flowerbed = listOf(1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1)
    val n = 8
    var nums = intArrayOf(0,1,0,3,12)
    val easy = Easy()
    var chars = charArrayOf('a','a','b','b','c','c','c')

    println(easy.moveZeroes(nums))
}

