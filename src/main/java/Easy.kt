class Easy {
    fun alterMerge(w1: String, w2: String): String{
        var finalString = ""
        var temp = ""
        if(w1.length > w2.length)
        for (i in w1.indices){
            for (j in w2.indices){
                if(i == j){
                    finalString += w1[i].toString() + w2[j].toString()
                    break
                }
            }
        }
        return finalString
    }
}

fun main() {
    var w1 = "abc"
    var w2 = "pqr"
    var easy = Easy()

    println("${easy.alterMerge(w1, w2)}")
}

