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

    fun winnerOfGame(colors: String): Boolean {
        var countA = 0
        var countB = 0

        for (i in 1 until colors.length - 1) {
            if (colors[i - 1] == 'A' && colors[i] == 'A' && colors[i + 1] == 'A') {
                countA++
            } else if (colors[i - 1] == 'B' && colors[i] == 'B' && colors[i + 1] == 'B') {
                countB++
            }
        }

        return countA > countB
    }

}


fun main() {
    val leetCodeStreak = LeetCodeStreak()
    var testString = "ABBBBBBBAAA"
    println(leetCodeStreak.winnerOfGame(testString))
}
