package striversA2ZDsa

import kotlin.math.min

fun hcfBrute(a: Int, b: Int): Int {
    var result = 0
     for (i in min(a, b) downTo 1) {
         if(a % i == 0 && b % i == 0) {
             result = i
             break
         }
     }
    return result
}

fun hcfOptimised(a: Int, b: Int): Int {
    if (b == 0) return a
    return hcfOptimised(b, a % b)
}

fun primeCheck(a: Int): Boolean {
    var count = 0
    if (a == 1) {
        return false
    }
    for (i in a/2 downTo 1) {
        if (a % 2 == 0) {
            count++
            if (count > 1) break
        }
    }

    return count <= 1
}

fun main() {
    var a = readln().toInt()
    println("PrimeCheck : ${primeCheck(a)}")
}
