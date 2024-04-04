package com.neojou

import java.util.PriorityQueue
import kotlin.system.measureNanoTime

fun nextGreaterElement1(nums1: IntArray, nums2: IntArray): IntArray {
    // convert nums2 into map
    var mutablemap = mutableMapOf<Int, Int>()
    for (i in nums2.indices)
        mutablemap.put(nums2[i], i)

    val out = IntArray(nums1.size)
    for (i in nums1.indices) {
        val j: Int? = mutablemap[nums1[i]]
        j ?: continue

        var k: Int = j + 1
        while (k < nums2.size) {
            if (nums2[k] > nums1[i]) break
            k++
        }
        if (k < nums2.size) // found
            out[i] = nums2[k]
        else // not found
            out[i] = -1
    }
    return out
}

fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
    // not only the index <-> number, but finding out the bigger number and put into map
    val map: HashMap<Int, Int> = HashMap()
    val q: PriorityQueue<Int> = PriorityQueue()
    for (i in nums2.indices) {
        val cur = nums2[i]
        while (q.isNotEmpty() && q.peek()!! < cur) {
            map.put(q.poll(), cur)
        }
        q.add(cur)
    }

    val out = IntArray(nums1.size)
    for (i in nums1.indices) {
        out[i] = map.getOrDefault(nums1[i], -1)
    }
    return out
}

fun main() {
    val nums1 = intArrayOf(4,1,2)
    val nums2 = intArrayOf(1,3,4,2)

    println("Only Use Map:" + measureNanoTime {
        print("[")
        nextGreaterElement1(nums1, nums2).forEach { print(it.toString() + ", ") }
        println("]")
    })

    println("Use PriorityQueue:" + measureNanoTime {
        print("[")
        nextGreaterElement(nums1, nums2).forEach { print(it.toString() + ", ") }
        println("]")
    })

}



