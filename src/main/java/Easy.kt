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
}

fun main() {
    val w1 = "ab"
    val w2 = "pqrs"
    val str1 = "LEET"
    val str2 = "CODE"
    val easy = Easy()

    println(easy.gcdStrings(str1, str2))
}

