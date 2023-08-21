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
}

fun main() {
    val w1 = "ab"
    val w2 = "pqrs"
    val easy = Easy()

    println(easy.alterMerge(w1, w2))
}

