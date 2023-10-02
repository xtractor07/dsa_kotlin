package leetCodeSolutioning

class LeetCodeStreak {

    fun reverseWords(s: String): String {
        val result = mutableListOf<String>()
        for (i in s.split("\\s+".toRegex())) {
            var temp = ""
            for (j in i.length - 1 downTo 0) {
                temp += i[j].toString()
            }
            result.add(temp)
        }
        return result.joinToString (" ")
    }

    fun reverseWordsOptimised(s: String): String {
        return s.split(" ".toRegex()).joinToString(" ") {it.reversed()}
    }

}


fun main() {
    val leetCodeStreak = LeetCodeStreak()
    var testString = "This is a test string"
    println(leetCodeStreak.reverseWords(testString))
}
