package com.neojou

import kotlin.system.measureNanoTime

import java.util.Stack
import java.util.EmptyStackException

fun containsDuplicate1(nums: IntArray): Boolean {
    nums.sort()
    for (i in 0 until nums.size - 1)
        if (nums[i] == nums[i + 1]) return true
    return false
}

fun containsDuplicate2(nums: IntArray): Boolean {
    val ht = HashSet<Int>()

    for (i in 0 until nums.size) {
        if ( ht.contains(nums[i]) ) return true
        ht.add(nums[i])
    }
    return false
}

fun containsDuplicate(nums: IntArray): Boolean {
    val ht = HashSet<Int>()

    nums.forEach {
        if ( ht.contains(it) ) return true
        ht.add(it)
    }
    return false
}

fun main() {

    // true
    val nums1 = intArrayOf(1, 2, 3, 1)
    println(containsDuplicate(nums1))

    // false
    val nums2 = intArrayOf(1, 2, 3, 4)
    println(containsDuplicate(nums2))

    // true
    val nums3 = intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)
    println(containsDuplicate(nums3))
}




