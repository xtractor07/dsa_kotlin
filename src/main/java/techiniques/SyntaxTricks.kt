package techiniques

fun main() {

    /**
     * Take multiple spaced input in variables*/
    var(a, b, c, d) = readln().split(" ").map( String::toInt )
    println("$a, $b, $c, $d")

    /**
     * Take multiple spaced input in a list*/
    var li = readln().split(" ").map(String::toInt)
    println("$li")

    /**
     * Print an array in a single line rather than running a loop*/
    var intArray = intArrayOf(1, 2, 3, 4, 5, 6)
    println(intArray.joinToString(", "))
}
