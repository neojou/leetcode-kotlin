package com.neojou

import kotlin.system.measureNanoTime

fun matrixReshape1(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
    val m = mat.size
    val n = mat[0].size
    if ( m * n != r * c) return mat

    val ret = Array(r) { IntArray(c) }
    var mi = 0
    var nj = 0
    for (i in ret.indices) {
        for (j in ret[0].indices) {
            ret[i][j] = mat[mi][nj]
            nj++
            if (nj == n) {
                mi++
                nj = 0
            }
        }
    }
    return ret
}

fun matrixReshape2(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
    val m = mat.size
    val n = mat[0].size
    if ( m * n != r * c) return mat

    val nums = mutableListOf<Int>()
    for (i in mat.indices) {
        for (j in mat[0].indices) {
            nums.add(mat[i][j])
        }
    }

    val ret = Array(r) { IntArray(c) }
    var index = 0
    for (i in ret.indices)
        for (j in ret[0].indices)
            ret[i][j] = nums[index++]
    return ret
}

fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
    val m = mat.size
    val n = mat[0].size
    if ( m * n != r * c) return mat

    val nums = IntArray(m * n)
    var index = 0
    for (i in mat.indices) {
        for (j in mat[0].indices) {
            nums[index++] = mat[i][j]
        }
    }

    val ret = Array(r) { IntArray(c) }
    index = 0
    for (i in ret.indices)
        for (j in ret[0].indices)
            ret[i][j] = nums[index++]
    return ret
}

fun main() {
    val mat = arrayOf(intArrayOf(1,2), intArrayOf(3,4))

    val ret0 : Array<IntArray>
    val time0 = measureNanoTime { ret0 = matrixReshape1(mat, 1, 4) }
    print("Result skip [" + time0 +"] : [")
    for (i in ret0.indices) {
        print(ret0[i].toList().toString())
        print(", ")
    }
    println("]\n")

    val ret1 : Array<IntArray>
    val time1 = measureNanoTime { ret1 = matrixReshape1(mat, 1, 4) }
    print("Result 1 [" + time1 +"] : [")
    for (i in ret1.indices) {
        print(ret1[i].toList().toString())
        print(", ")
    }
    println("]\n")

    val ret2 : Array<IntArray>
    val time2 = measureNanoTime { ret2 = matrixReshape2(mat, 1, 4) }
    print("Result 2 [" + time2 +"] : [")
    for (i in ret2.indices) {
        print(ret2[i].toList().toString())
        print(", ")
    }
    println("]\n")

    val ret : Array<IntArray>
    val time = measureNanoTime { ret = matrixReshape(mat, 1, 4) }
    print("Result [" + time +"] : [")
    for (i in ret.indices) {
        print(ret[i].toList().toString())
        print(", ")
    }
    println("]\n")


}


