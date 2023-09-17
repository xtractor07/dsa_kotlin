class DataStructures {
    data class MinMaxPair(
            val min: Int,
            val max: Int
    )

    fun maxMin(arr: List<Int>): MinMaxPair {
        var max = 0
        var min = 0
        for (i in arr) {
            if (i > max) {
                max = i
            }
            if (i < min) {
                min = i
            }
        }
        return MinMaxPair(min, max)
    }

    fun reverseArray(list: List<Int>): MutableList<Int> {
        var reverseList = mutableListOf<Int>()
        for (idx in (list.size - 1) downTo  0){
            reverseList.add(list[idx])
        }
        return  reverseList
    }

    fun rotateArray(li: List<Int>, k: Int): List<Int> {
        var temp = mutableListOf<Int>()
        var liCopy = li.toMutableList()
        for(idx in li.indices){
            if(idx >= k){
                temp.add(li[idx])
                liCopy.remove(li[idx])
            }
        }
        return (temp + liCopy)
    }
}


fun main() {
    val arr = listOf(3, 5, 1, 7, 9, 0)
    val arrRotate = listOf(1, 2, 3, 4, 5, 6, 7, 8)
    val k = 4
    var dataStructures = DataStructures()
    println("${dataStructures.rotateArray(arrRotate, k) }")
}

