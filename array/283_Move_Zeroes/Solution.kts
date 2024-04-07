package com.neojou

import kotlin.system.measureNanoTime

fun moveZeroes1(nums: IntArray): Unit {
    var i = 0
    while (i < nums.size) {
        if (nums[i] == 0) {
            var j = i + 1
            while (j < nums.size) {
                if (nums[j] != 0) break
                j++
            }
            if (j == nums.size) return
            nums[i] = nums[j]
            nums[j] = 0

        }
        i++
    }
}

fun moveZeroes2(nums: IntArray): Unit {
    var firstZero = 0
    for (i in nums.indices) {
        if (nums[i] != 0) {
            swap(firstZero, i, nums)
            firstZero++
        }
    }
}

inline fun swap(i1: Int, i2:Int, nums: IntArray) {
    if (i1 == i2) return
    val temp = nums[i2]
    nums[i2] = nums[i1]
    nums[i1] = temp
}


fun main() {
    val nums1 = intArrayOf(0,1,0,3,12)
    val time1 = measureNanoTime { moveZeroes1(nums1) }
    println("Result Time[" + time1 + "] : " + nums1.toList().toString())

    val nums2 = intArrayOf(0,1,0,3,12)
    val time2 = measureNanoTime { moveZeroes2(nums2) }
    println("Result Time[" + time2 + "] : " + nums2.toList().toString())
}


