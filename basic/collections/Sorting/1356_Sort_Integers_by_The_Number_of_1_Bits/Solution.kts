package com.neojou

import kotlin.system.measureNanoTime

fun showIntArray(arr: IntArray) {
    print("[")
    if (arr.size > 0) {
        print(arr[0])
        for (i in 1 until arr.size)
            print(", " + arr[i])
    }
    print("]")
}

val bitsNumberMap : MutableMap<Int, Int> = HashMap()

fun get1BitsNumber(n: Int) : Int{
    val ret: Int
    if (bitsNumberMap.containsKey(n) == false) {
        ret = n.countOneBits()
        bitsNumberMap[n] = ret
    } else {
        ret = bitsNumberMap[n]!!
    }
    return ret
}

fun sortByBits1(arr: IntArray): IntArray {
    var ret = arr.toMutableList()
    ret.sortWith(compareBy({get1BitsNumber(it)}, {it}))
    return ret.toIntArray()
}

fun sortByBits2(arr: IntArray): IntArray {
    val map: MutableMap<Int, MutableList<Int>> = HashMap()
    for (n in arr) {
        val bits = n.countOneBits()
        map.putIfAbsent(bits, ArrayList())
        map[bits]!!.add(n)
    }
    val ret = IntArray(arr.size)
    var i = 0
    for((_, list) in map) {
        list.sort()
        for (n in list) {
            ret[i++] = n
        }
    }
    return ret
}

fun sortByBits(arr: IntArray): IntArray {
    for (i in arr.indices)
        arr[i] = arr[i] or (arr[i].countOneBits().shl(16) )

    arr.sort()

    for (i in arr.indices)
        arr[i] = arr[i] and 0x00FFFF
    
    return arr
}


fun main() {
    val arr : List<Int> = listOf(0,1,2,3,4,5,6,7,8)
    val res = sortByBits(arr.toIntArray())

    showIntArray(res)
}


