package com.neojou

import kotlin.system.measureNanoTime

import java.util.Stack
import java.util.EmptyStackException

class NumArray1(nums: IntArray) {
    var nums = nums
    fun sumRange(left: Int, right: Int): Int {
        var ans = 0
        for (i in left..right) {
            ans += nums[i]
        }
        return ans
    }

}

class NumArray(nums: IntArray) {
    var accunums = IntArray(nums.size)

    init {
        accunums[0] = nums[0]
        for (i in 1 until accunums.size) {
            accunums[i] = accunums[i - 1] + nums[i]
        }
    }

    fun sumRange(left: Int, right: Int): Int {
        if (left == 0) return accunums[right]
        return accunums[right] - accunums[left - 1]
    }
}

fun main() {
    val nums = intArrayOf(-2, 0, 3, -5, 2, -1)
    val numA = NumArray(nums)
    println(numA.sumRange(0,2))
    println(numA.sumRange(2,5))
    println(numA.sumRange(0,5))
}




