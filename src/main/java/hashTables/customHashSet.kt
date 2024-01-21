package hashTables

import kotlin.math.absoluteValue

class MyHashSet<T>(private val capacity: Int = 100) {
    private val table: Array<MutableList<T>?> = arrayOfNulls(capacity)

    fun add(element: T): Boolean {
        val bucketIndex = getBucketIndex(element)
        if (table[bucketIndex] == null) {
            table[bucketIndex] = mutableListOf(element)
            return true
        }

        val bucket = table[bucketIndex]!!
        if (element !in bucket) {
            bucket.add(element)
            return true
        }
        return false
    }

    fun remove(element: T): Boolean {
        val bucketIndex = getBucketIndex(element)
        val bucket = table[bucketIndex] ?: return false

        return bucket.remove(element)
    }

    fun contains(element: T): Boolean {
        val bucketIndex = getBucketIndex(element)
        val bucket = table[bucketIndex] ?: return false

        return element in bucket
    }

    private fun getBucketIndex(element: T): Int {
        return element.hashCode().absoluteValue % capacity
    }
}

fun main() {
    val hashSet = MyHashSet<String>()
    hashSet.add("Hello")
    hashSet.add("World")
    println(hashSet.contains("Hello"))
    println(hashSet.contains("Kotlin"))
}