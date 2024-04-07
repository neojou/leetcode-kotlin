package com.neojou

fun sumOddLengthSubarrays1(arr: IntArray): Int {
    var sum = 0
    for (len in 1..arr.size step 2) {
        for (index in 0 until arr.size) {
            if (index + len > arr.size)
                break
            for (i in index until index + len)
                sum += arr[i]
        }
    }
    return sum
}

fun sumOddLengthSubarrays(arr: IntArray): Int {
    val len = arr.size
    var sum = 0
    for (i in 0..len - 1) {
        sum = sum + ((i + 1) * (len - i) + 1) / 2 * arr[i]
    }
    return sum
}

fun main() {
    val coordinates = intArrayOf(1,4,2,5,3)
    println("Result:" + sumOddLengthSubarrays(coordinates))
}


