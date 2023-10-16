package striversA2ZDsa

/**
 * Lists*/

val list = listOf(1, 2, 3, 4) //Immutable
val mutableList = listOf(1, 2, 3, 4) //Mutable

/**
 * Set*/

val set = setOf(1, 2, 3, 4) //Immutable
val mutableSet = mutableSetOf(1, 2, 3, 4) //Mutable

/**
 * Map (Key-Value pairs)*/

val map = mapOf(1 to "One", 2 to "Two") //Immutable
val mutableMap = mutableMapOf(1 to "One", 2 to "Two")


fun countOccurrences(arr: IntArray): Map<Int, Int> {
    val countMap = mutableMapOf<Int, Int>()
    for (num in arr) {
        countMap[num] = countMap.getOrDefault(num, 0) + 1
    }
    return countMap
}

fun charFreqCount(charArr: CharArray): Map<Char, Int> {
    val charFreqMap = mutableMapOf<Char, Int>()
    for (char in charArr) {
        charFreqMap[char] = charFreqMap.getOrDefault(char, 0) + 1
    }
    return charFreqMap
}

fun main() {
    /*val arr = intArrayOf(5, 2, 3, 3, 4, 5, 1, 2, 2)
    val freqMap = countOccurrences(arr)
    freqMap.forEach { (key, value) ->
        println("$key : $value")
    }*/
    val string = readln().replace(" ", "").toCharArray()
    val freqMap = charFreqCount(string)
    freqMap.forEach { (char, count) ->
        if (count == 1) {
            println(char)
            return
        }
    }
}
